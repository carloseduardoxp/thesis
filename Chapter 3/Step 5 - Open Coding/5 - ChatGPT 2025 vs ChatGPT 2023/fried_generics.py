import os
import pandas as pd
import scikit_posthocs as sp
from scipy.stats import friedmanchisquare

script_dir = os.path.dirname(os.path.abspath(__file__))
path = os.path.join(script_dir, "readability_generics.csv")

df = pd.read_csv(path)
df = df.drop(columns=["snippet_id"]).dropna()

stat, p = friedmanchisquare(*[df[col] for col in df.columns])
print(f"Friedman statistic: {stat:.4f}, p-value: {p:.4e}")

nemenyi = sp.posthoc_nemenyi_friedman(df.values)

nemenyi.index = df.columns
nemenyi.columns = df.columns

print("\nNemenyi Post-hoc Comparison:")
print(nemenyi)
