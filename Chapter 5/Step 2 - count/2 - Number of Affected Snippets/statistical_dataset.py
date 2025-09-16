import os
from pathlib import Path
import pandas as pd

# ===== Configuração =====
SCRIPT_DIR = Path(__file__).resolve().parent
INPUT_CSV  = SCRIPT_DIR / "dataset_total.csv"
OUTPUT_CSV = SCRIPT_DIR / "corrected_binary.csv"

REMAINING_COLS = ["chatgpt_remaining", "deepseek_remaining", "gemini_remaining"]
OUTPUT_COLS = ["chatgpt_corrected", "deepseek_corrected", "gemini_corrected"]

def main():
    if not INPUT_CSV.exists():
        raise FileNotFoundError(f"Não encontrei o arquivo: {INPUT_CSV}")

    df = pd.read_csv(INPUT_CSV, dtype={"query_id_llm": "string"})
    expected = ["query_id_llm", "before"] + REMAINING_COLS
    missing = [c for c in expected if c not in df.columns]
    if missing:
        raise ValueError(f"Colunas ausentes no CSV: {missing}")

    # Garante numérico (se vier string). NaN vira 0 (tratado como 'corrigido' se ficar == 0).
    for col in REMAINING_COLS:
        df[col] = pd.to_numeric(df[col], errors="coerce").fillna(0)

    # Cria as colunas binárias: 1 se remaining == 0, senão 0
    out = pd.DataFrame({"query_id_llm": df["query_id_llm"]})
    for rem_col, out_col in zip(REMAINING_COLS, OUTPUT_COLS):
        out[out_col] = (df[rem_col] == 0).astype(int)

    # Salva resultado
    out.to_csv(OUTPUT_CSV, index=False)

    # Resumo rápido
    print(f"Arquivo de entrada: {INPUT_CSV}")
    print(f"Linhas processadas: {len(out)}")
    for col in OUTPUT_COLS:
        total_ones = int(out[col].sum())
        print(f"{col}: 1 = {total_ones} | 0 = {len(out) - total_ones}")
    print(f"\nSaída gerada em: {OUTPUT_CSV}")

if __name__ == "__main__":
    main()
