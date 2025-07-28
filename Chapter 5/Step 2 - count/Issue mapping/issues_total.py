import os
import csv
import pandas as pd

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))

BASE_DIR = r"C:\Atividades\UFU\Doutorado\Thesis\Replication Package\Chapter 5\Step 1 - script llm\data"
BASELINES = ["Gemini","chatgpt2025", "deepseek"]
CSV_PREFIX = "sonarLintAnalysis_version_"

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
    "java:S3358": "Clean Up", 
    "java:S3985": "Clean Up",        
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
    "java:S6395": "Prefer Concise Code"
}

TARGET_RULES = set(RULE_CATEGORY_MAP.keys())

result = []

for snippet_id in range(2, 358):
    row = {"snippet_id": snippet_id}
    snippet_path = os.path.join(BASE_DIR, str(snippet_id))
    if not os.path.isdir(snippet_path):
       continue

    for llm_affected in os.listdir(snippet_path):
        llm_affected_path = os.path.join(snippet_path, llm_affected)
        if not os.path.isdir(llm_affected_path):
            continue

        for baseline in BASELINES:
            baseline_dir = os.path.join(llm_affected_path, baseline)
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

output_path = os.path.join(SCRIPT_DIR, "issues_sample_total.csv")
df = pd.DataFrame(result)
df.to_csv(output_path, index=False)
print(f"[✓] Arquivo gerado: {output_path}")
