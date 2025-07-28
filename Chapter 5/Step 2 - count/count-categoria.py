import os
import pandas as pd
import re
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

        minha_lista = []

        original_path = os.path.join(original_base, query_id, llm_affected)
        if not os.path.isdir(original_path):
            print(f"🚫 query_id={query_id}, llm_affected={llm_affected}. LLM Fixed {llm_fixed}")
            raise SystemExit("❌ Nao eh diretorio.") 

        original_file = next(
            (f for f in os.listdir(original_path) if f.startswith("sonarLintAnalysis_version_10.22")), None
        )
        if not original_file:
            print(f"🚫 query_id={query_id}, llm_affected={llm_affected}. LLM Fixed {llm_fixed}")
            raise SystemExit("❌ Nao achou arquivo original.") 

        original_file_path = os.path.join(original_path, original_file)
        original_issues = extract_readability_issues(original_file_path)

        for llm_fixed in os.listdir(llm_affected_path):
            llm_fixed_path = os.path.join(llm_affected_path, llm_fixed)
            if not os.path.isdir(llm_fixed_path):
                continue

            for refactor_file in os.listdir(llm_fixed_path):
                if not refactor_file.endswith(".java.csv"):
                    continue

                minha_lista.append(llm_fixed)

                refactor_file_path = os.path.join(llm_fixed_path, refactor_file)
                fixed_issues = extract_readability_issues(refactor_file_path)

                corrected = original_issues - fixed_issues
                not_corrected = original_issues & fixed_issues
                introduced = fixed_issues - original_issues

                # Agrupar por categoria
                corrected_by_category = defaultdict(set)
                not_corrected_by_category = defaultdict(set)
                introduced_by_category = defaultdict(set)

                for issue in corrected:
                    cat = RULE_CATEGORY_MAP.get(issue, "Uncategorized")
                    corrected_by_category[cat].add(issue)

                for issue in not_corrected:
                    cat = RULE_CATEGORY_MAP.get(issue, "Uncategorized")
                    not_corrected_by_category[cat].add(issue)

                for issue in introduced:
                    cat = RULE_CATEGORY_MAP.get(issue, "Uncategorized")
                    introduced_by_category[cat].add(issue)

                # Atualizar contadores
                categories = set(list(corrected_by_category.keys()) + list(not_corrected_by_category.keys()) + list(introduced_by_category.keys()))

                for category in categories:
                    if category in introduced_by_category:
                        category_counters[(llm_fixed, category)]["introduced"] += 1
                    if category in not_corrected_by_category:
                        category_counters[(llm_fixed, category)]["not_corrected"] += 1
                    # Só conta como corrected se não teve nenhum "not_corrected"
                    elif category in corrected_by_category:
                        category_counters[(llm_fixed, category)]["corrected"] += 1

                
   
        if len(minha_lista) < 3:
            print(f"🚫 CSV não encontrado query_id={query_id}, llm_affected={llm_affected}")
            raise SystemExit("❌ LLM nao encontrado. Encerrando execução.")      

summary_rows = [
    {
        "llm_fixed": llm,
        "category": cat,
        "corrected": counts["corrected"],
        "not_corrected": counts["not_corrected"],
        "introduced": counts["introduced"]
    }
    for (llm, cat), counts in category_counters.items()
]

df_summary = pd.DataFrame(summary_rows)
df_summary.sort_values(by=["llm_fixed", "category"], inplace=True)
df_summary.to_csv("readability_issues_summary_detailed.csv", index=False)

print("✅ Resumo detalhado salvo em 'readability_issues_summary_detailed.csv'")