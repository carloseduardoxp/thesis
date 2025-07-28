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
    "java:S1450",
    "java:S117",
    "java:S100", 
    "java:S3008",
    "java:S101", 
    "java:S116", 
    "java:S115", 
    "java:S1197",
    "java:S1659",
    "java:S1124",
    "java:S2234",
    "java:S3973",
    "java:S128", 
    "java:S131", 
    "java:S1301",
    "java:S127", 
    "java:S5843",
    "java:S6035",
    "java:S6353",
    "java:S6397",
    "java:S4719",
    "java:S1192",
    "java:S1117",
    "java:S2387",
    "java:S4977",
    "java:S1444",
    "java:S1161",
    "java:S1165",
    "java:S3740",
    "java:S3252",
    "java:S2209",
    "java:S1171",
    "java:S2440",
    "java:S3010",
    "java:S1700",
    "java:S6213",
    "java:S3358",
    "java:S1141",
    "java:S112", 
    "java:S1068",
    "java:S108", 
    "java:S1116",
    "java:S1130",
    "java:S1144",
    "java:S1172",
    "java:S1186",
    "java:S1481",
    "java:S1854",
    "java:S2094",
    "java:S2326",
    "java:S3457",
    "java:S4925",
    "java:S1871",
    "java:S125", 
    "java:S1858",
    "java:S1125",
    "java:S2293",
    "java:S1905",
    "java:S2129",
    "java:S2130",
    "java:S1126",
    "java:S1488",
    "java:S3626",
    "java:S1066",
    "java:S2147",
    "java:S1612",
    "java:S1604",
    "java:S1611",
    "java:S1602",
    "java:S2093",
    "java:S7158",
    "java:S2140",
    "java:S3012",
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
output_csv = os.path.join(script_dir, "readability_occurrences_total.csv")
df_result.to_csv(output_csv, index=False)
