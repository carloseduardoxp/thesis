import os
import pandas as pd
from collections import defaultdict
import pandas as pd
from collections import Counter


refactor_base = r"../Step 1 - script llm/data"
original_base = r"../../Chapter 3/Replication Package/Step 4 - Code Readability Issues/1 - Extract Issues/data"

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
    "java:S3985": "Clean Up",
    "java:S6395": "Prefer Concise Code",
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

original_category_counter = Counter()

def extract_readability_issues(file_path):
    print(f"\n🔍 Lendo arquivo: {file_path}")
    found_issues = set()

    try:
        with open(file_path, "r", encoding="utf-8") as f:
            for line in f:
                for issue in RULE_CATEGORY_MAP:
                    if issue in line:
                        found_issues.add(issue)

        print(f"🎯 Regras de readability encontradas: {found_issues}")
        return found_issues

    except Exception as e:
        print(f"❌ Erro ao ler {file_path}: {e}")
        return set()

results = []

category_counters = defaultdict(lambda: {"corrected": 0, "introduced": 0, "not_corrected": 0})

for query_id in os.listdir(refactor_base):
    query_path = os.path.join(refactor_base, query_id)
    if not os.path.isdir(query_path):
        continue

    for llm_affected in os.listdir(query_path):
        llm_affected_path = os.path.join(query_path, llm_affected)
        if not os.path.isdir(llm_affected_path):
            continue

        original_path = os.path.join(original_base, query_id, llm_affected)
        if not os.path.isdir(original_path):
            continue

        original_file = next(
            (f for f in os.listdir(original_path) if f.startswith("sonarLintAnalysis_version_10.22")), None
        )
        if not original_file:
            continue

        original_file_path = os.path.join(original_path, original_file)
        original_issues = extract_readability_issues(original_file_path)

        categories_in_snippet = set()

        for issue in original_issues:
            category = RULE_CATEGORY_MAP.get(issue, "Uncategorized")
            categories_in_snippet.add(category)

        for category in categories_in_snippet:
            original_category_counter[category] += 1            
                
df_original_summary = pd.DataFrame(
    [{"category": cat, "total_issues_original": count} for cat, count in original_category_counter.items()]
)
df_original_summary.sort_values(by="total_issues_original", ascending=False, inplace=True)
df_original_summary.to_csv("readability_issues_original_summary.csv", index=False)

print("✅ Resumo detalhado salvo em 'readability_issues_summary_detailed.csv'")
