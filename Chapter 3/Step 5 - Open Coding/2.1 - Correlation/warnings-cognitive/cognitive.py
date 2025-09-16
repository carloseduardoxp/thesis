import pandas as pd
from scipy.stats import spearmanr, pearsonr

import os

script_dir = os.path.dirname(os.path.abspath(__file__))
cognitive_path = os.path.join(script_dir, "cognitive_occurrences_total.csv")
warnings_path = os.path.join(script_dir, "readability_occurrences_total.csv")

warnings = pd.read_csv(warnings_path)
complexity = pd.read_csv(cognitive_path)

df = pd.merge(warnings, complexity, on="snippet_id", suffixes=("_warnings", "_complexity"))

baselines = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

warnings_long = df.melt(id_vars="snippet_id", 
                        value_vars=[col + "_warnings" for col in baselines],
                        var_name="baseline", value_name="warnings")

complexity_long = df.melt(id_vars="snippet_id", 
                          value_vars=[col + "_complexity" for col in baselines],
                          var_name="baseline", value_name="complexity")

warnings_long["baseline"] = warnings_long["baseline"].str.replace("_warnings", "")
complexity_long["baseline"] = complexity_long["baseline"].str.replace("_complexity", "")

merged = pd.merge(warnings_long, complexity_long, on=["snippet_id", "baseline"])

spearman_corr = spearmanr(merged["warnings"], merged["complexity"])

print("Spearman correlation:", spearman_corr)

for b in merged["baseline"].unique():
    subset = merged[merged["baseline"] == b]
    s_corr = spearmanr(subset["warnings"], subset["complexity"])
    print(f"{b}: Spearman={s_corr.correlation:.3f}, p={s_corr.pvalue:.3g}")
