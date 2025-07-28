import os
import csv
from collections import defaultdict
import pandas as pd

BASE_DIR = r"C:\Users\carlo\Downloads\VEM_LLMs_Readability\Replication Package\Step 4 - Code Readability Issues\1 - Extract Issues\data"

BASELINES = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

RULE_CATEGORY_MAP = {
    "java:S1858": "Eliminate Redundancy",
    "java:S1125": "Eliminate Redundancy",
    "java:S2293": "Eliminate Redundancy",
    "java:S1905": "Eliminate Redundancy",
    "java:S2129": "Eliminate Redundancy",
    "java:S2130": "Eliminate Redundancy",
    "java:S1126": "Eliminate Redundancy",
    "java:S1488": "Eliminate Redundancy",
    "java:S3626": "Eliminate Redundancy",
    "java:S1066": "Merge Redundant Blocks",
    "java:S2147": "Merge Redundant Blocks",
    "java:S1612": "Simplify Lambdas",
    "java:S1604": "Simplify Lambdas",
    "java:S1611": "Simplify Lambdas",
    "java:S1602": "Simplify Lambdas",
    "java:S2093": "Use Try With Resources",
    "java:S7158": "Prefer Built-in Methods",
    "java:S2140": "Prefer Built-in Methods",
    "java:S3012": "Prefer Built-in Methods",
}

TARGET_RULES = set(RULE_CATEGORY_MAP.keys())

instancias = defaultdict(lambda: {b: 0 for b in BASELINES})
snippets = defaultdict(lambda: {b: set() for b in BASELINES})
categoria_snippets = defaultdict(lambda: {b: set() for b in BASELINES})
categoria_instancias = defaultdict(lambda: {b: 0 for b in BASELINES})
total_snippets = {b: set() for b in BASELINES}
total_instancias = {b: 0 for b in BASELINES}

for folder_name in os.listdir(BASE_DIR):
    folder_path = os.path.join(BASE_DIR, folder_name)
    if not os.path.isdir(folder_path):
        continue

    for baseline in BASELINES:
        baseline_path = os.path.join(folder_path, baseline)
        if not os.path.isdir(baseline_path):
            continue

        for file_name in os.listdir(baseline_path):
            if file_name.startswith("sonarLintAnalysis_version_10.22") and file_name.endswith(".csv"):
                file_path = os.path.join(baseline_path, file_name)
                try:
                    with open(file_path, newline='', encoding='utf-8', errors='replace') as f:
                        reader = csv.DictReader(f)
                        regras_encontradas = set()
                        categorias_encontradas = set()
                        for row in reader:
                            rule_key = row.get("rule key", "").strip()
                            if rule_key in TARGET_RULES:
                                instancias[rule_key][baseline] += 1
                                snippets[rule_key][baseline].add(file_path)
                                categoria = RULE_CATEGORY_MAP[rule_key]
                                categoria_snippets[categoria][baseline].add(file_path)
                                categoria_instancias[categoria][baseline] += 1
                                total_snippets[baseline].add(file_path)
                                total_instancias[baseline] += 1
                except Exception as e:
                    print(f"Erro ao ler {file_path}: {e}")

data = []

for rule in sorted(TARGET_RULES):
    row = {"rule_key": rule}
    for baseline in BASELINES:
        row[f"{baseline}_code_snippets"] = len(snippets[rule][baseline])
        row[f"{baseline}_instancias"] = instancias[rule][baseline]
    data.append(row)

for categoria in sorted(set(RULE_CATEGORY_MAP.values())):
    row = {"rule_key": f"TOTAL_{categoria.replace(' ', '_').upper()}"}
    for baseline in BASELINES:
        row[f"{baseline}_code_snippets"] = len(categoria_snippets[categoria][baseline])
        row[f"{baseline}_instancias"] = categoria_instancias[categoria][baseline]
    data.append(row)

row_total = {"rule_key": "TOTAL_GERAL"}
for baseline in BASELINES:
    row_total[f"{baseline}_code_snippets"] = len(total_snippets[baseline])
    row_total[f"{baseline}_instancias"] = total_instancias[baseline]
data.append(row_total)

df = pd.DataFrame(data)

ordered_cols = ["rule_key"]
for b in BASELINES:
    ordered_cols.extend([f"{b}_code_snippets", f"{b}_instancias"])
df = df[ordered_cols]

script_dir = os.path.dirname(os.path.abspath(__file__))
output_csv = os.path.join(script_dir, "readability_issues_concise.csv")

df.to_csv(output_csv, index=False, encoding='utf-8')
print(f"Arquivo gerado: {output_csv}")
