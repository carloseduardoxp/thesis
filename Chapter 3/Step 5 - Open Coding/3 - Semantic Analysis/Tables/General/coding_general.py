import os
import csv
from collections import defaultdict
import pandas as pd

BASE_DIR = r"C:\Users\carlo\Downloads\VEM_LLMs_Readability\Replication Package\Step 4 - Code Readability Issues\1 - Extract Issues\data"

BASELINES = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

RULE_CATEGORY_MAP = {
    "java:S6541": "Improve Code Modularity",
    "java:S3776": "Improve Code Modularity",
    "java:S1479": "Improve Code Modularity",
    "java:S135": "Improve Code Modularity",
    "java:S1450": "Improve Code Modularity",
     "java:S117": "Convention",
    "java:S100": "Convention",
    "java:S3008": "Convention",
    "java:S101": "Convention",
    "java:S116": "Convention",
    "java:S115": "Convention",
    "java:S1197": "Convention",
    "java:S1659": "Convention",
    "java:S1124": "Convention",
    "java:S2234": "Convention",
    "java:S3973": "Convention",
    "java:S128": "Convention",
    "java:S131": "Convention",
    "java:S1301": "Convention",
    "java:S127": "Convention",
    "java:S5843": "Clarify Code Intent",
    "java:S6035": "Clarify Code Intent",
    "java:S6353": "Clarify Code Intent",
    "java:S6397": "Clarify Code Intent",
    "java:S4719": "Clarify Code Intent",
    "java:S1192": "Clarify Code Intent",
    "java:S1117": "Clarify Code Intent",
    "java:S2387": "Clarify Code Intent",
    "java:S4977": "Clarify Code Intent",
    "java:S1444": "Clarify Code Intent",
    "java:S1161": "Clarify Code Intent",
    "java:S1165": "Clarify Code Intent",
    "java:S3740": "Clarify Code Intent",
    "java:S3252": "Clarify Code Intent",
    "java:S2209": "Clarify Code Intent",
    "java:S1171": "Clarify Code Intent",
    "java:S2440": "Clarify Code Intent",
    "java:S3010": "Clarify Code Intent",
    "java:S1700": "Clarify Code Intent",
    "java:S6213": "Clarify Code Intent",
    "java:S3358": "Clarify Code Intent",
    "java:S1141": "Clarify Code Intent",
    "java:S112": "Clarify Code Intent",
    "java:S1068": "Clean Up",
    "java:S108": "Clean Up",
    "java:S1116": "Clean Up",
    "java:S1130": "Clean Up",
    "java:S1144": "Clean Up",
    "java:S1172": "Clean Up",
    "java:S1186": "Clean Up",
    "java:S1481": "Clean Up",
    "java:S1854": "Clean Up",
    "java:S2094": "Clean Up",
    "java:S2326": "Clean Up",
    "java:S3457": "Clean Up",
    "java:S4925": "Clean Up",
    "java:S1871": "Clean Up",
    "java:S125": "Clean Up",
    "java:S1858": "Prefer Concise Code",
    "java:S1125": "Prefer Concise Code",
    "java:S2293": "Prefer Concise Code",
    "java:S1905": "Prefer Concise Code",
    "java:S2129": "Prefer Concise Code",
    "java:S2130": "Prefer Concise Code",
    "java:S1126": "Prefer Concise Code",
    "java:S1488": "Prefer Concise Code",
    "java:S3626": "Prefer Concise Code",
    "java:S1066": "Prefer Concise Code",
    "java:S2147": "Prefer Concise Code",
    "java:S1612": "Prefer Concise Code",
    "java:S1604": "Prefer Concise Code",
    "java:S1611": "Prefer Concise Code",
    "java:S1602": "Prefer Concise Code",
    "java:S2093": "Prefer Concise Code",
    "java:S7158": "Prefer Concise Code",
    "java:S2140": "Prefer Concise Code",
    "java:S3012": "Prefer Concise Code",
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
output_csv = os.path.join(script_dir, "readability_issues_general.csv")

df.to_csv(output_csv, index=False, encoding='utf-8')
print(f"Arquivo gerado: {output_csv}")
