import os
import csv

root_dir = "C:\\Users\\carlo\\Downloads\\VEM_LLMs_Readability\\Replication Package\\Step 4 - Code Readability Issues\\1 - Extract Issues\\data"
prefix = "sonarLintAnalysis_version_10.22.0.81232"
expected_header = ["rule key", "start line", "end line", "severity", "message", "type"]

matching_files = []
csv_found = False

for dirpath, _, filenames in os.walk(root_dir):
    for filename in filenames:
        if filename.startswith(prefix) and filename.endswith(".csv"):
            csv_found = True
            file_path = os.path.join(dirpath, filename)
            try:
                with open(file_path, newline='', encoding='utf-8') as csvfile:
                    reader = csv.reader(csvfile)
                    rows = list(reader)

                    if len(rows) == 1 and rows[0] == expected_header:
                        matching_files.append(file_path)
            except Exception as e:
                print(f"Erro ao processar {file_path}: {e}")

if not csv_found:
    print("Nenhum arquivo CSV com o prefixo especificado foi encontrado.")

elif not matching_files:
    print("Nenhum arquivo possui apenas o cabeçalho esperado.")
else:
    print("Arquivos com apenas o cabeçalho esperado:")
    for path in matching_files:
        print(path)
