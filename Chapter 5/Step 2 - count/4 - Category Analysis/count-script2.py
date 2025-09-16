import re
import os
import pandas as pd

refactor_base = r"../Step 1 - script llm/data"
original_base = r"../../Chapter 3/Step 4 - Code Readability Issues/1 - Extract Issues/data"

readability_issues = {
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
"java:S3985",
"java:S6395"
}

def extract_readability_issues(file_path):
    print(f"\n🔍 Lendo arquivo: {file_path}")
    found_issues = set()

    try:
        with open(file_path, "r", encoding="utf-8") as f:
            for line in f:
                for issue in readability_issues:
                    if issue in line:
                        found_issues.add(issue)

        print(f"🎯 Regras de readability encontradas: {found_issues}")
        return found_issues

    except Exception as e:
        print(f"❌ Erro ao ler {file_path}: {e}")
        return set()

results = []

for query_id in os.listdir(refactor_base):

    query_path = os.path.join(refactor_base, query_id)
    if not os.path.isdir(query_path):
        print(f"🚫 Diretorio não encontrado para query_id={query_id}. Diretorio nao encontrado {query_path}")
        raise SystemExit("❌ Diretorio nao encontrado. Encerrando execução.")  

    for llm_warning_readability in os.listdir(query_path):
        llm_path = os.path.join(query_path, llm_warning_readability)
        if not os.path.isdir(llm_path):
           print(f"🚫 Arquivo não encontrado para query_id={query_id}, llm_warning_readability={llm_warning_readability}. Diretorio nao encontrado {llm_path}")
           raise SystemExit("❌ Diretorio nao encontrado. Encerrando execução.")                

        for refactor_projects in os.listdir(llm_path):
            refactor_project_path = os.path.join(llm_path, refactor_projects)
            if not os.path.isdir(refactor_project_path):
                continue

            for refactor_file in os.listdir(refactor_project_path):
                if not refactor_file.endswith(".java.csv"):
                    continue
                
                llm_fixed = refactor_projects
                refactor_file_path = os.path.join(refactor_project_path, refactor_file)
                fixed_issues = extract_readability_issues(refactor_file_path)

                original_llm_dir = os.path.join(original_base, query_id, llm_warning_readability)
                if not os.path.isdir(original_llm_dir):
                    print(f"🚫 Arquivo não encontrado para query_id={query_id}, llm_warning_readability={llm_warning_readability}. Diretorio original nao encontrado: {original_llm_dir}")
                    raise SystemExit("❌ Erro: Diretorio não encontrado. Encerrando execução.")                

                original_file = next(
                    (f for f in os.listdir(original_llm_dir) if f.startswith("sonarLintAnalysis_version_10.22")), None
                )
                if not original_file:
                    print(f"🚫 Arquivo não encontrado para query_id={query_id}, llm_warning_readability={llm_warning_readability}. Verifique o arquivo: {original_file_path}")
                    raise SystemExit("❌ Erro: Arquivo não encontrado. Encerrando execução.")                

                original_file_path = os.path.join(original_llm_dir, original_file)
                original_issues = extract_readability_issues(original_file_path)
                
                if not original_issues:
                    print(f"🚫 Nenhuma readability issue encontrada no original para query_id={query_id}, llm_warning_readability={llm_warning_readability}. Verifique o arquivo: {original_file_path}")
                    raise SystemExit("❌ Erro: Código original sem issues de readability. Encerrando execução.")

                corrected = original_issues - fixed_issues
                not_corrected = original_issues & fixed_issues
                introduced = fixed_issues - original_issues

                for issue in corrected:
                    results.append((query_id, llm_warning_readability, llm_fixed, issue, "corrected"))
                for issue in not_corrected:
                    results.append((query_id, llm_warning_readability, llm_fixed, issue, "not_corrected"))
                for issue in introduced:
                    results.append((query_id, llm_warning_readability, llm_fixed, issue, "introduced"))

df = pd.DataFrame(results, columns=["query_id", "llm_warning", "llm_fixed", "issue", "status"])
df.to_csv("readability_issues_analysis.csv", index=False)

print("Análise concluída. Resultados salvos em 'readability_issues_analysis.csv'")