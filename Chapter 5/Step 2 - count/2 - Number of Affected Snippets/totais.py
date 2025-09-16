import os
import hashlib
import pandas as pd
import numpy as np

# ===== CONFIG =====
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
CSV_PATH = os.path.join(SCRIPT_DIR, "dataset_clarify.csv")

LLM_COLS = ["chatgpt_remaining", "deepseek_remaining", "gemini_remaining"]
CHECK_COLS = ["before"] + LLM_COLS  # só para validar presença

def sha256_of(path: str) -> str:
    with open(path, "rb") as f:
        return hashlib.sha256(f.read()).hexdigest()

print(f"Arquivo: {CSV_PATH}")
print(f"SHA-256: {sha256_of(CSV_PATH)}")

df = pd.read_csv(CSV_PATH)
print(f"Shape: {df.shape}")
print("Dtypes:", df.dtypes.to_dict())

# ===== Checar colunas =====
missing = [c for c in CHECK_COLS if c not in df.columns]
if missing:
    raise ValueError(f"Colunas ausentes: {missing}")

# ===== Classificação binária por LLM =====
# Regras:
# - remaining == 0            -> corrected
# - remaining > 0             -> not_corrected
# - NaN ou valor negativo     -> unknown
def classify_series(s: pd.Series) -> pd.Series:
    s_num = pd.to_numeric(s, errors="coerce")
    status = pd.Series(index=s_num.index, dtype="object")
    status[s_num.isna() | (s_num < 0)] = "unknown"
    status[s_num == 0] = "corrected"
    status[s_num > 0] = "not_corrected"
    return status

for col in LLM_COLS:
    status_col = col.replace("_remaining", "_status")
    df[status_col] = classify_series(df[col])

# ===== Resumo por LLM =====
print("\nResumo binário por LLM (contagens e percentuais sobre válidos):")
for col in LLM_COLS:
    status_col = col.replace("_remaining", "_status")
    counts = df[status_col].value_counts(dropna=False).to_dict()
    corrected = int((df[status_col] == "corrected").sum())
    not_corr  = int((df[status_col] == "not_corrected").sum())
    unknown   = int((df[status_col] == "unknown").sum())
    valid = corrected + not_corr

    print(f"\n- {col}:")
    print(f"  corrected     = {corrected}")
    print(f"  not_corrected = {not_corr}")
    print(f"  unknown       = {unknown}")

    if valid > 0:
        print(f"  % corrected (sobre válidos)     = {100*corrected/valid:.2f}%")
        print(f"  % not_corrected (sobre válidos) = {100*not_corr/valid:.2f}%")
    else:
        print("  [Aviso] Nenhum valor válido (todos NaN/negativos).")

# ===== (Opcional) salvar classificação por linha =====
out_path = os.path.join(SCRIPT_DIR, "modularity_binary_classification.csv")
cols_to_save = ["query_id_llm", "before"] if "query_id_llm" in df.columns else ["before"]
cols_to_save += LLM_COLS + [c.replace("_remaining", "_status") for c in LLM_COLS]
df[cols_to_save].to_csv(out_path, index=False)
print(f"\nArquivo gerado: {out_path}")
