import os
import pandas as pd
from scipy.stats import friedmanchisquare
import scikit_posthocs as sp

script_dir = os.path.dirname(os.path.abspath(__file__))
path = os.path.join(script_dir, "dataset_total.csv")

df = pd.read_csv(path)

cols = ["chatgpt_remaining", "deepseek_remaining", "gemini_remaining"]
data = df[cols].dropna()

stat, p = friedmanchisquare(*[data[c] for c in cols])
print(f"Friedman χ²={stat:.4f}, p-value={p:.4e}")

nemenyi = sp.posthoc_nemenyi_friedman(data.values)
nemenyi.index = cols
nemenyi.columns = cols

print("\nNemenyi Post-hoc Comparison (p-valores):")
print(nemenyi)
