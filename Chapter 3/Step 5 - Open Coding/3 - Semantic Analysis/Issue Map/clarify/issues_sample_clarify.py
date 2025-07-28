import os
import csv
import pandas as pd

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))

BASE_DIR = r"C:\Users\carlo\Downloads\VEM_LLMs_Readability\Replication Package\Step 4 - Code Readability Issues\1 - Extract Issues\data"
BASELINES = ["Gemini", "stackoverflow", "chatgpt", "chatgpt2025", "deepseek"]
CSV_PREFIX = "sonarLintAnalysis_version_"

# Regras de interesse
RULE_CATEGORY_MAP = {
    "java:S5843": "Improve Regex Expressions",
    "java:S6035": "Improve Regex Expressions",
    "java:S6353": "Improve Regex Expressions",
    "java:S6397": "Improve Regex Expressions",
    "java:S4719": "Replace Magic Literals",
    "java:S1192": "Replace Magic Literals",
    "java:S1117": "Avoid Shadowing",
    "java:S2387": "Avoid Shadowing",
    "java:S4977": "Avoid Shadowing",
    "java:S1444": "Use Proper Modifiers",
    "java:S1161": "Use Proper Modifiers",
    "java:S1165": "Use Proper Modifiers",
    "java:S3740": "Use Proper Modifiers",
    "java:S3252": "Use Static Property",
    "java:S2209": "Use Static Property",
    "java:S1171": "Use Static Property",
    "java:S2440": "Use Static Property",
    "java:S3010": "Use Static Property",
    "java:S1700": "Improve Naming",
    "java:S6213": "Improve Naming",
    "java:S3358": "Avoid Nested Structures",
    "java:S1141": "Avoid Nested Structures",
    "java:S112": "Use Specific Exceptions",
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

        # Procura o CSV do SonarLint
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

output_path = os.path.join(SCRIPT_DIR, "issues_sample_clarify.csv")
df = pd.DataFrame(result)
df.to_csv(output_path, index=False)
print(f"[✓] Arquivo gerado: {output_path}")
