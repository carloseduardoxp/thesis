import os
import pandas as pd

script_dir = os.path.dirname(os.path.abspath(__file__))
csv_path = os.path.join(script_dir, "dataset_modularity.csv")

LLM_COLS = ["chatgpt_remaining", "deepseek_remaining", "gemini_remaining"]

def classify(before, remaining):
    """
    Regras:
    - remaining == 0                      -> 'corrected'
    - remaining > 0 and before == 0       -> 'introduced'
    - remaining > 0 and before > 0        -> 'not_corrected'
    """
    if remaining == 0:
        return "corrected"
    if remaining > 0 and before == 0:
        return "introduced"
    if remaining > 0 and before > 0:
        return "not_corrected"
    return "unknown"  # caso raro (faltantes/negativos)

def main():
    df = pd.read_csv(csv_path)

    df["before"] = pd.to_numeric(df["before"], errors="coerce").fillna(0).astype(int)
    for c in LLM_COLS:
        df[c] = pd.to_numeric(df[c], errors="coerce").fillna(0).astype(int)

    for c in LLM_COLS:
        status_col = c.replace("_remaining", "_status")
        df[status_col] = [classify(b, r) for b, r in zip(df["before"], df[c])]

    print("Resumo de contagens por LLM:")
    for c in LLM_COLS:
        status_col = c.replace("_remaining", "_status")
        counts = df[status_col].value_counts().to_dict()
        print(f"- {c}: {counts}")

    cols_to_save = (
        ["query_id_llm", "before"] +
        LLM_COLS +
        [c.replace("_remaining", "_status") for c in LLM_COLS]
    )
    out_path = os.path.join(script_dir, "modularity_by_llm.csv")
    df[cols_to_save].to_csv(out_path, index=False)
    print(f"\nArquivo gerado: {out_path}")

if __name__ == "__main__":
    main()
