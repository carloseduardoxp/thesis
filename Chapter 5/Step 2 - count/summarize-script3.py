import pandas as pd

df = pd.read_csv("readability_issues_analysis.csv")

df["llm_fixed_clean"] = df["llm_fixed"].str.extract(r"(\w+)", expand=False)

grouped = df.groupby(["issue", "llm_fixed_clean", "status"]).size()

summary = grouped.unstack(level=["llm_fixed_clean", "status"], fill_value=0)

summary.columns = [f"{llm}_{status}" for llm, status in summary.columns]

summary = summary.reset_index()

summary["total"] = summary.drop(columns=["issue"]).sum(axis=1)
summary = summary.sort_values(by="total", ascending=False).drop(columns=["total"])

summary.to_csv("resumo_readability_por_regra.csv", index=False)

print(summary)
