#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re
import os
import pandas as pd

# ========= Config =========
INPUT_CSV  = os.path.join(os.path.dirname(__file__), "readability_issues_analysis.csv")
OUTPUT_CSV = os.path.join(os.path.dirname(__file__), "resumo_readability_por_regra.csv")

# Ordem desejada das colunas (além de "issue", que vai primeiro)
ORDER = [
    "ChatGpt2025_corrected", "DeepSeek_corrected", "Gemini_corrected",
    "ChatGpt2025_not_corrected", "DeepSeek_not_corrected", "Gemini_not_corrected",
    "ChatGpt2025_introduced", "DeepSeek_introduced", "Gemini_introduced",
]

# ========= Helpers =========
def canon_llm_name(value: str) -> str:
    """
    Extrai um token do nome do LLM e normaliza para:
      - ChatGpt2025
      - DeepSeek
      - Gemini
    Mantém desconhecidos como o token extraído.
    """
    s = "" if pd.isna(value) else str(value)
    m = re.search(r"[A-Za-z0-9_.-]+", s)
    token = m.group(0) if m else s
    low = token.lower()

    # Mapeamentos comuns para canonizar
    if low.startswith(("chatgpt2025", "chatgpt", "gpt")):
        return "ChatGpt2025"
    if low.startswith("deepseek"):
        return "DeepSeek"
    if low.startswith("gemini"):
        return "Gemini"
    return token  # fallback (caso apareça algo fora do trio)

# ========= Main =========
def main():
    # Ler dados
    df = pd.read_csv(INPUT_CSV)

    # Checar colunas mínimas
    required_cols = {"issue", "llm_fixed", "status"}
    missing = required_cols - set(df.columns)
    if missing:
        raise ValueError(f"Colunas ausentes no CSV: {sorted(missing)}")

    # Normalizar nome do LLM
    df["llm_fixed_clean"] = df["llm_fixed"].apply(canon_llm_name)

    # Contagem por (issue, llm, status)
    grouped = df.groupby(["issue", "llm_fixed_clean", "status"]).size()

    # Tabela larga com colunas (llm, status)
    summary = grouped.unstack(level=["llm_fixed_clean", "status"], fill_value=0)

    # Achatar nomes das colunas: "LLM_status"
    summary.columns = [f"{llm}_{status}" for llm, status in summary.columns]

    # Ordenar por total (opcional, só para priorizar no arquivo)
    summary["__total__"] = summary.sum(axis=1, numeric_only=True)
    summary = summary.sort_values("__total__", ascending=False).drop(columns="__total__")

    # Trazer 'issue' de volta como coluna
    summary = summary.reset_index()

    # Garantir que TODAS as colunas da ORDER existam; se faltar, criar com 0
    for col in ORDER:
        if col not in summary.columns:
            summary[col] = 0

    # Reordenar: issue + ORDER + (quaisquer outras colunas que tenham sobrado)
    fixed_first = ["issue"] + ORDER
    others = [c for c in summary.columns if c not in fixed_first]
    summary = summary[fixed_first + others]

    # Salvar CSV
    summary.to_csv(OUTPUT_CSV, index=False)

    # Log rápido
    print(f"Arquivo de entrada: {INPUT_CSV}")
    print(f"Linhas (regras) no resumo: {len(summary)}")
    print(f"Colunas na ordem fixa: {ORDER}")
    print(f"Saída gerada em: {OUTPUT_CSV}")

if __name__ == "__main__":
    main()
