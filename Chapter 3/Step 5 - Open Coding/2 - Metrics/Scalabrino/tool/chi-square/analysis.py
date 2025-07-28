import pandas as pd
import os
import numpy as np
from scipy.stats import chi2_contingency
from collections import defaultdict
import seaborn as sns
import matplotlib.pyplot as plt

script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, "scalabrino.csv")

def classify_readability(score):
    if score < 0.416:
        return 'unreadable'
    elif score <= 0.60:
        return 'undetermined'
    else:
        return 'readable'

df = pd.read_csv(file_path)
df['readability_class'] = df['readability_score'].apply(classify_readability)

counts = defaultdict(lambda: defaultdict(int))
for _, row in df.iterrows():
    baseline = row['baseline']
    category = row['readability_class']
    counts[baseline][category] += 1

result_df = pd.DataFrame.from_dict(counts, orient='index').fillna(0).astype(int)
result_df = result_df[['readable', 'undetermined', 'unreadable']]  
print("Contagem por baseline e classe:")
print(result_df)

chi2_stat, p_value, dof, expected = chi2_contingency(result_df.values)
residuals = (result_df.values - expected) / np.sqrt(expected)

flattened_data = []
for i, baseline in enumerate(result_df.index):
    for j, cls in enumerate(result_df.columns):
        category = f"{baseline} {cls}"
        count = result_df.iloc[i, j]
        resid = residuals[i, j]
        flattened_data.append({'category': category, 'count': count, 'residual': resid})

residual_df = pd.DataFrame(flattened_data)

print("\nResumo com resíduos padronizados:")
print(residual_df)

sns.heatmap(residuals, annot=True, cmap="coolwarm", center=0, fmt=".2f")
plt.title("Resíduos Ajustados do Qui-Quadrado")
plt.show()