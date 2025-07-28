import os
import csv
from collections import defaultdict
import pandas as pd

BASE_DIR = r"../../Step 4 - Code Readability Issues/1 - Extract Issues/data"

BASELINES = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

RULE_CATEGORY_MAP = {
    "java:S6541": "Methods",
    "java:S3776": "Methods",
    "java:S1479": "Conditions",
    "java:S135": "Loops",
    "java:S1450": "Attributes",
     "java:S117": "Local Variable",
    "java:S100": "Methods",
    "java:S3008": "Attributes",
    "java:S101": "Classes",
    "java:S116": "Attributes",
    "java:S115": "Constant",
    "java:S1197": "Local Variable",
    "java:S1659": "Local Variable",
    "java:S1124": "Modifiers",
    "java:S2234": "Parameters",
    "java:S3973": "Conditions",
    "java:S128": "Conditions",
    "java:S131": "Conditions",
    "java:S1301": "Conditions",
    "java:S127": "Loops",
    "java:S5843": "Regex",
    "java:S6035": "Regex",
    "java:S6353": "Regex",
    "java:S6397": "Regex",
    "java:S4719": "Statements",
    "java:S1192": "Statements",
    "java:S1117": "Local Variable",
    "java:S2387": "Attributes",
    "java:S4977": "Generics",
    "java:S1444": "Attributes",
    "java:S1161": "Modifiers",
    "java:S1165": "Modifiers",
    "java:S3740": "Generics",
    "java:S3252": "Attributes",
    "java:S2209": "Attributes",
    "java:S1171": "Assignment",
    "java:S2440": "Classes",
    "java:S3010": "Attributes",
    "java:S1700": "Attributes",
    "java:S6213": "Local Variable",
    "java:S3358": "Conditions",
    "java:S1141": "Exceptions",
    "java:S112": "Exceptions",
    "java:S1068": "Attributes",
    "java:S108": "Loops",
    "java:S1116": "Methods",
    "java:S1130": "Exceptions",
    "java:S1144": "Methods",
    "java:S1172": "Methods",
    "java:S1186": "Methods",
    "java:S1481": "Local Variable",
    "java:S1854": "Assignment",
    "java:S2094": "Classes",
    "java:S2326": "Generics",
    "java:S3457": "Parameters",
    "java:S4925": "Statements",
    "java:S1871": "Conditions",
    "java:S125": "Comments",
    "java:S1858": "Statements",
    "java:S1125": "Conditions",
    "java:S2293": "Generics",
    "java:S1905": "Statements",
    "java:S2129": "Assignment",
    "java:S2130": "Statements",
    "java:S1126": "Conditions",
    "java:S1488": "Assignment",
    "java:S3626": "Conditions",
    "java:S1066": "Conditions",
    "java:S2147": "Exceptions",
    "java:S1612": "Lambda",
    "java:S1604": "Lambda",
    "java:S1611": "Lambda",
    "java:S1602": "Lambda",
    "java:S2093": "Exceptions",
    "java:S7158": "Conditions",
    "java:S2140": "Statements",
    "java:S3012": "Loops",
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

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))

output_path = os.path.join(SCRIPT_DIR, "syntatic.csv")
df.to_csv(output_path, index=False, encoding='utf-8')
print(f"[✓] Arquivo gerado: {output_path}")
