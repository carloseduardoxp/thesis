import os
import pandas as pd

refactor_base = r"../../Step 1 - script llm/data"
original_base = r"../../../Chapter 3/Step 4 - Code Readability Issues/1 - Extract Issues/data"

readability_issues = {
"java:S1854",
"java:S1481",
"java:S125",
"java:S1186",
"java:S1068",
"java:S2094",
"java:S1172",
"java:S108", 
"java:S1144",
"java:S4925",
"java:S1130",
"java:S3457",
"java:S1116",
"java:S2326",
"java:S1871",
"java:S3985"
}

def extract_readability_issues(file_path):
    found_issues = set()
    try:
        with open(file_path, "r", encoding="utf-8") as f:
            for line in f:
                for issue in readability_issues:
                    if issue in line:
                        found_issues.add(issue)
        return found_issues
    except Exception as e:
        print(f"Erro ao ler {file_path}: {e}")
        return set()

status_dict = {}

for query_id in os.listdir(refactor_base):
    query_path = os.path.join(refactor_base, query_id)
    if not os.path.isdir(query_path):
        continue

    for llm_original in os.listdir(query_path):
        llm_path = os.path.join(query_path, llm_original)
        if not os.path.isdir(llm_path):
            continue

        for llm_fixed in os.listdir(llm_path):
            refactor_path = os.path.join(llm_path, llm_fixed)
            if not os.path.isdir(refactor_path):
                continue

            for file_name in os.listdir(refactor_path):
                if not file_name.endswith(".java.csv"):
                    continue

                remaining_issues = extract_readability_issues(os.path.join(refactor_path, file_name))

                original_path = os.path.join(original_base, query_id, llm_original)
                if not os.path.isdir(original_path):
                    continue

                original_file = next((f for f in os.listdir(original_path) if f.startswith("sonarLintAnalysis_version_10.22")), None)
                if not original_file:
                    continue

                original_issues = extract_readability_issues(os.path.join(original_path, original_file))
                if not original_issues and not remaining_issues:
                    continue

                issues_before = len(original_issues)

                corrected = original_issues - remaining_issues
                not_corrected = original_issues & remaining_issues
                introduced = remaining_issues - original_issues

                issues_after = len(not_corrected) +  len(introduced)

                key = f"{query_id}_{llm_original.lower()}"
                if key not in status_dict:
                    status_dict[key] = {}

                status_dict[key][llm_fixed.lower()] = issues_after
                status_dict[key]['before'] = issues_before

df = pd.DataFrame.from_dict(status_dict, orient='index')
df = df.reset_index().rename(columns={'index': 'query_id_llm'})

for col in ['before','chatgpt2025', 'deepseek', 'gemini']:
    if col not in df.columns:
        df[col] = 0
    else:
        df[col] = df[col].fillna(0).astype(int)

df = df[['query_id_llm', 'before','chatgpt2025', 'deepseek', 'gemini']]
df.columns = ['query_id_llm', 'before','chatgpt_remaining', 'deepseek_remaining', 'gemini_remaining']

# Salvar CSV
df.to_csv("dataset_clean.csv", index=False)
print("✅ Arquivo 'dataset_clean.csv' gerado com sucesso!")