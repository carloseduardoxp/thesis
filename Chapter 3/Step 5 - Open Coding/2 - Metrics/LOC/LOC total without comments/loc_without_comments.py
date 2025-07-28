import os
import pandas as pd

BASE_DIR = r"C:\Users\carlo\Downloads\VEM_LLMs_Readability\Replication Package\Step 4 - Code Readability Issues\1 - Extract Issues\data"
BASELINES = ["Gemini", "stackoverflow", "chatgpt", "chatgpt2025", "deepseek"]

results = []

for snippet_id in range(2, 358):
    row = {"snippet_id": snippet_id}
    snippet_path = os.path.join(BASE_DIR, str(snippet_id))

    if not os.path.isdir(snippet_path):
        continue

    for baseline in BASELINES:
        baseline_dir = os.path.join(snippet_path, baseline)

        if not os.path.isdir(baseline_dir):
            row[baseline] = None
            continue

        java_file = next((os.path.join(baseline_dir, f) for f in os.listdir(baseline_dir) if f.endswith(".java")), None)

        if java_file:
            try:
                with open(java_file, 'r', encoding='utf-8') as file:
                    lines = file.readlines()

                    lines = [line.strip() for line in lines]

                    count = 0
                    inside_block_comment = False
                    for line in lines:
                        if inside_block_comment:
                            if "*/" in line:
                                inside_block_comment = False
                            continue
                        if line.startswith("/*"):
                            inside_block_comment = True
                            continue
                        if line.startswith("//") or line == "":
                            continue
                        count += 1

                    row[baseline] = count
            except Exception as e:
                print(f"[Erro ao ler arquivo] {java_file}: {e}")
                row[baseline] = None
        else:
            row[baseline] = None

    results.append(row)

script_dir = os.path.dirname(os.path.abspath(__file__))

output_path = os.path.join(script_dir, "loc_no_comments_or_blank.csv")

df = pd.DataFrame(results)
df.to_csv(output_path, index=False)
print(f"[✓] Arquivo '{output_path}' gerado com sucesso.")
