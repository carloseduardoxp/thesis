import os
import csv
from collections import defaultdict
import pandas as pd

BASE_DIR = r"../../Step 1 - script llm/data"

BASELINES = ["stackOverflow","Gemini", "ChatGpt","ChatGpt2025", "DeepSeek"]

rule_counts = defaultdict(lambda: {b: 0 for b in BASELINES})

for folder_name in os.listdir(BASE_DIR):
    folder_path = os.path.join(BASE_DIR, folder_name)
    if not os.path.isdir(folder_path):
        continue

    for baseline in BASELINES:
        baseline_path = os.path.join(folder_path, baseline)
        if not os.path.isdir(baseline_path):
            continue

        for refactor_dir in os.listdir(baseline_path):
            refactor_dir_path = os.path.join(baseline_path, refactor_dir)
            if not os.path.isdir(refactor_dir_path):
                continue

            for file_name in os.listdir(refactor_dir_path):
                if file_name.startswith("sonarLintAnalysis_version_10.22") and file_name.endswith(".csv"):
                    file_path = os.path.join(refactor_dir_path, file_name)
                    try:
                        with open(file_path, newline='', encoding='utf-8', errors='replace') as f:
                            reader = csv.DictReader(f)
                            for row in reader:
                                rule_key = row.get("rule key", "").strip()
                                row_type = row.get("type","").strip()                            
                                if rule_key.startswith("java:"):
                                    rule_counts[rule_key][refactor_dir] += 1
                    except Exception as e:
                        print(f"Erro ao ler {file_path}: {e}")

df = pd.DataFrame.from_dict(rule_counts, orient='index').reset_index()
df.rename(columns={'index': 'rule_key'}, inplace=True)

df["total"] = df[BASELINES].sum(axis=1)
df = df.sort_values(by="total", ascending=False).drop(columns="total")

script_dir = os.path.dirname(os.path.abspath(__file__))

output_path = os.path.join(script_dir, "readability_issues_pivot.csv")
df.to_csv(output_path, index=False, encoding='utf-8')
print(f"Arquivo gerado: {output_path}")
