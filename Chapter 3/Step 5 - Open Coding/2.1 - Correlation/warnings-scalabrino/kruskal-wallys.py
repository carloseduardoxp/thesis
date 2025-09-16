import pandas as pd
import numpy as np
from scipy.stats import kruskal
import scikit_posthocs as sp
from itertools import combinations
import os


script_dir = os.path.dirname(os.path.abspath(__file__))
WARNINGS_CSV = os.path.join(script_dir, "readability_occurrences_total.csv")
READABILITY_CSV = os.path.join(script_dir, "readability_matrix.csv")

# Atenção aos nomes de colunas (case-sensitive)
BASELINES = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

# ---------- LOAD ----------
warnings = pd.read_csv(WARNINGS_CSV)
readab   = pd.read_csv(READABILITY_CSV)

# Verifica colunas esperadas
missing_w = set(["snippet_id"] + BASELINES) - set(warnings.columns)
missing_r = set(["snippet_id"] + BASELINES) - set(readab.columns)
if missing_w:
    raise ValueError(f"Colunas ausentes em warnings.csv: {missing_w}")
if missing_r:
    raise ValueError(f"Colunas ausentes em readability.csv: {missing_r}")

# ---------- LONG FORMAT ----------
w_long = warnings.melt(id_vars="snippet_id", value_vars=BASELINES,
                       var_name="baseline", value_name="warnings")
r_long = readab.melt(id_vars="snippet_id", value_vars=BASELINES,
                     var_name="baseline", value_name="readability_class")  # 1,2,3

df = pd.merge(w_long, r_long, on=["snippet_id", "baseline"], how="inner")

# Filtra classes válidas (1,2,3) e garante numérico
df = df[df["readability_class"].isin([1,2,3])].copy()
df["warnings"] = pd.to_numeric(df["warnings"], errors="coerce")
df = df.dropna(subset=["warnings"])

# ---------- FUNÇÕES AUX ----------
def kruskal_effect_size(groups):
    """
    Epsilon squared (ε²) para Kruskal–Wallis.
    groups: lista de arrays (uma por grupo)
    Fórmula: ε² = (H - k + 1) / (n - k)
    """
    k = len(groups)
    n = sum(len(g) for g in groups)
    # H do kruskal:
    H, _ = kruskal(*groups)
    eps2 = (H - k + 1) / (n - k) if (n - k) > 0 else np.nan
    return H, eps2

def dunn_posthoc(df_baseline):
    """
    Dunn’s test com correção de Holm.
    Retorna DataFrame de p-ajustados entre pares de grupos (1,2,3).
    """
    # scikit-posthocs espera uma série de valores e grupos:
    pvals = sp.posthoc_dunn(
        df_baseline,
        val_col="warnings",
        group_col="readability_class",
        p_adjust="holm"
    )
    # Ordena linhas/colunas para 1,2,3 se existirem
    order = [c for c in [1,2,3] if c in pvals.index]
    pvals = pvals.loc[order, order]
    return pvals

# ---------- ANÁLISE ----------
results = []
posthocs = {}

for b in BASELINES:
    sub = df[df["baseline"] == b].copy()
    # Separa por classe 1,2,3 (só usa classes que existem)
    groups = []
    labels_presentes = []
    for cls in [1,2,3]:
        vals = sub.loc[sub["readability_class"] == cls, "warnings"].values
        if len(vals) > 0:
            groups.append(vals)
            labels_presentes.append(cls)
    # Precisa de pelo menos 2 grupos com dados
    if len(groups) < 2:
        results.append((b, np.nan, np.nan, len(groups), labels_presentes))
        continue

    # Kruskal–Wallis
    H, p_kw = kruskal(*groups)
    # Epsilon squared
    _, eps2 = kruskal_effect_size(groups)

    results.append((b, H, p_kw, len(groups), labels_presentes))

    # Dunn post hoc se significativo
    if p_kw < 0.05:
        ph = dunn_posthoc(sub)
        posthocs[b] = ph

# ---------- RELATÓRIO ----------
res_df = pd.DataFrame(results, columns=["baseline", "H (Kruskal)", "p-value", "#groups", "classes_present"])
print("\n=== Kruskal–Wallis por baseline (warnings ~ readability_class) ===")
print(res_df.to_string(index=False))

print("\n=== Tamanho de efeito aproximado (ε²) ===")
# Recalcula ε² por baseline para adicionar junto
rows = []
for b in BASELINES:
    sub = df[df["baseline"] == b]
    groups = [sub.loc[sub["readability_class"] == cls, "warnings"].values
              for cls in [1,2,3] if (sub["readability_class"] == cls).any()]
    if len(groups) >= 2:
        _, eps2 = kruskal_effect_size(groups)
        rows.append((b, eps2))
    else:
        rows.append((b, np.nan))
eff = pd.DataFrame(rows, columns=["baseline", "epsilon_squared"])
print(eff.to_string(index=False))

if posthocs:
    print("\n=== Dunn’s test (p-ajustado, Holm) para baselines com Kruskal significativo ===")
    for b, ph in posthocs.items():
        print(f"\nBaseline: {b}")
        print(ph)
else:
    print("\nNenhum baseline apresentou diferença global significativa (Kruskal) ao nível de 5%, logo Dunn’s não foi aplicado.")
