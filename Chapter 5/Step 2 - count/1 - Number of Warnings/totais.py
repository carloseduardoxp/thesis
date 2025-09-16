import os
import hashlib
import pandas as pd

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
CSV_PATH = os.path.join(SCRIPT_DIR, "dataset_modularity.csv")

COLS = ["before", "chatgpt_remaining", "deepseek_remaining", "gemini_remaining"]

def sha256_of(path: str) -> str:
    with open(path, "rb") as f:
        return hashlib.sha256(f.read()).hexdigest()

print(f"Arquivo: {CSV_PATH}")
print(f"SHA-256: {sha256_of(CSV_PATH)}")

df = pd.read_csv(CSV_PATH)
print(f"Shape: {df.shape}")
print("Dtypes:", df.dtypes.to_dict())

totals = {}
nan_info = {}
for c in COLS:
    if c not in df.columns:
        raise ValueError(f"Coluna ausente: {c}")
    s = pd.to_numeric(df[c], errors="coerce")
    totals[c] = int(s.fillna(0).sum())
    nan_info[c] = int(s.isna().sum())

print("\nTotais por coluna (após coerção numérica):")
for c in COLS:
    print(f"- {c}: {totals[c]}")

before_total = totals["before"]
if before_total > 0:
    print("\nRedução percentual em relação ao 'before':")
    for c in COLS:
        if c == "before": 
            continue
        reduc = 100 * (before_total - totals[c]) / before_total
        print(f"- {c}: {reduc:.2f}%")
else:
    print("\nAviso: 'before' é zero; não é possível calcular redução percentual.")
