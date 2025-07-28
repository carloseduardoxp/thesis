import pandas as pd
import os

# Caminho do arquivo original
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, "scalabrino.csv")

# Mapeia scores para categorias numéricas
def classify_readability_numeric(score):
    if score < 0.416:
        return 3  # unreadable
    elif score <= 0.60:
        return 2  # undetermined
    else:
        return 1  # readable

# Lê o CSV original
df = pd.read_csv(file_path)

# Aplica classificação numérica
df['readability_class'] = df['readability_score'].apply(classify_readability_numeric)

# Pivotando os dados: linhas = snippet_id, colunas = baseline, valores = classe numérica
pivot_df = df.pivot(index='snippet_id', columns='baseline', values='readability_class')

# Garante a ordem das colunas
baseline_order = ['stackoverflow', 'chatgpt', 'chatgpt2025', 'deepseek', 'Gemini']
pivot_df = pivot_df[baseline_order]

# Reseta o índice para incluir snippet_id como coluna
pivot_df.reset_index(inplace=True)

# Exporta o novo CSV
output_path = os.path.join(script_dir, "readability_matrix.csv")
pivot_df.to_csv(output_path, index=False)

print("Arquivo gerado com sucesso em:", output_path)
