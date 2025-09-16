import pandas as pd
from statsmodels.stats.contingency_tables import cochrans_q, mcnemar

df = pd.read_csv("corrected_binary.csv")

llm_data = df[["chatgpt_corrected", "deepseek_corrected", "gemini_corrected"]]

result_cochran = cochrans_q(llm_data)
print("\n=== Teste de Cochran's Q ===")
print(f"Estatística Q = {result_cochran.statistic:.2f}")
print(f"Graus de liberdade = {result_cochran.df}")
print(f"Valor-p = {result_cochran.pvalue:.6f}")
if result_cochran.pvalue < 0.05:
    print("➡️ Diferença estatisticamente significativa entre os LLMs.")
else:
    print("➡️ Nenhuma diferença estatisticamente significativa entre os LLMs.")

def run_mcnemar(col1, col2):
    table = pd.crosstab(df[col1], df[col2])
    result = mcnemar(table, exact=True)
    
    print(f"\n=== McNemar: {col1} vs {col2} ===")
    print("Tabela de contingência:")
    print(table)
    print(f"Estatística = {result.statistic}")
    print(f"Valor-p = {result.pvalue:.6f}")
    
    col1_unique = table.loc[1, 0] if (1, 0) in table.index.to_flat_index() else 0
    col2_unique = table.loc[0, 1] if (0, 1) in table.index.to_flat_index() else 0
    
    if col1_unique > col2_unique:
        print(f"➡️ {col1} corrigiu mais onde {col2} falhou.")
    elif col2_unique > col1_unique:
        print(f"➡️ {col2} corrigiu mais onde {col1} falhou.")
    else:
        print("➡️ Ambos corrigiram a mesma quantidade de casos exclusivos.")

run_mcnemar("chatgpt_corrected", "deepseek_corrected")
run_mcnemar("chatgpt_corrected", "gemini_corrected")
run_mcnemar("deepseek_corrected", "gemini_corrected")
