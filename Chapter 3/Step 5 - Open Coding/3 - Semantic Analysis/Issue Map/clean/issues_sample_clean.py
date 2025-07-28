import os
import csv
import pandas as pd

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))

BASE_DIR = r"C:\Users\carlo\Downloads\VEM_LLMs_Readability\Replication Package\Step 4 - Code Readability Issues\1 - Extract Issues\data"
BASELINES = ["Gemini", "stackoverflow", "chatgpt", "chatgpt2025", "deepseek"]
CSV_PREFIX = "sonarLintAnalysis_version_"

RULE_CATEGORY_MAP = {
    "java:S1068": "Remove Useless Code",
    "java:S108": "Remove Useless Code",
    "java:S1116": "Remove Useless Code",
    "java:S1130": "Remove Useless Code",
    "java:S1144": "Remove Useless Code",
    "java:S1172": "Remove Useless Code",
    "java:S1186": "Remove Useless Code",
    "java:S1481": "Remove Useless Code",
    "java:S1854": "Remove Useless Code",
    "java:S2094": "Remove Useless Code",
    "java:S2326": "Remove Useless Code",
    "java:S3457": "Remove Useless Code",
    "java:S4925": "Remove Useless Code",
    "java:S1871": "Remove Duplicate Code",
    "java:S125": "Remove Commented Code",
}

TARGET_RULES = set(RULE_CATEGORY_MAP.keys())

result = []

for snippet_id in range(2, 358):
    row = {"snippet_id": snippet_id}
    snippet_path = os.path.join(BASE_DIR, str(snippet_id))

    for baseline in BASELINES:
        baseline_dir = os.path.join(snippet_path, baseline)
        rule_keys = []

        if not os.path.isdir(baseline_dir):
            row[baseline] = ""
            continue

        csv_file = next((f for f in os.listdir(baseline_dir) if f.startswith(CSV_PREFIX) and f.endswith(".csv")), None)
        if csv_file:
            csv_path = os.path.join(baseline_dir, csv_file)
            try:
                with open(csv_path, newline='', encoding='utf-8') as f:
                    reader = csv.DictReader(f)
                    for row_csv in reader:
                        rule_key = row_csv.get("rule key")
                        if rule_key in TARGET_RULES:
                            rule_keys.append(rule_key)
            except Exception as e:
                print(f"Erro ao ler {csv_path}: {e}")

        row[baseline] = ",".join(sorted(set(rule_keys)))

    result.append(row)

output_path = os.path.join(SCRIPT_DIR, "issues_sample_clean.csv")
df = pd.DataFrame(result)
df.to_csv(output_path, index=False)
print(f"[✓] Arquivo gerado: {output_path}")
