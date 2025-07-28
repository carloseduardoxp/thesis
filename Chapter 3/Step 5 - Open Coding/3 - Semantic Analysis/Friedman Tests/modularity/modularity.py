import os
import csv
from collections import defaultdict
import pandas as pd

BASE_DIR = r"../../Step 4 - Code Readability Issues/1 - Extract Issues/data"

BASELINES = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

TARGET_RULES = {
    "java:S6541",
    "java:S3776",
    "java:S1479",
    "java:S135",
    "java:S1450"
    }

results = []

for snippet_id in range(2, 358):
    snippet_data = {"snippet_id": snippet_id}
    snippet_path = os.path.join(BASE_DIR, str(snippet_id))

    if not os.path.isdir(snippet_path):
        continue

    for baseline in BASELINES:
        baseline_path = os.path.join(snippet_path, baseline)
        count = 0

        if not os.path.isdir(baseline_path):
            snippet_data[baseline] = None
            continue

        for file_name in os.listdir(baseline_path):
            if file_name.startswith("sonarLintAnalysis_version_10.22") and file_name.endswith(".csv"):
                file_path = os.path.join(baseline_path, file_name)
                try:
                    with open(file_path, newline='', encoding='utf-8', errors='replace') as f:
                        reader = csv.DictReader(f)
                        for row in reader:
                            rule_key = row.get("rule key", "").strip()
                            if rule_key in TARGET_RULES:
                                count += 1
                except Exception as e:
                    print(f"Erro ao ler {file_path}: {e}")
        snippet_data[baseline] = count

    results.append(snippet_data)

df_result = pd.DataFrame(results)
script_dir = os.path.dirname(os.path.abspath(__file__))
output_csv = os.path.join(script_dir, "readability_modularity.csv")
df_result.to_csv(output_csv, index=False)
