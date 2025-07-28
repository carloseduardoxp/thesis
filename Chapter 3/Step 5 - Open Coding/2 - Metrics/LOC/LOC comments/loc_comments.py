import os
import pandas as pd

BASE_DIR = r"../../Step 4 - Code Readability Issues/1 - Extract Issues/data"
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

        java_file = None
        for f in os.listdir(baseline_dir):
            if f.endswith(".java"):
                java_file = os.path.join(baseline_dir, f)
                break

        if java_file:
            try:
                with open(java_file, 'r', encoding='utf-8') as file:
                    lines = file.readlines()
                    in_block_comment = False
                    comment_lines = 0

                    for line in lines:
                        stripped = line.strip()
                        if in_block_comment:
                            comment_lines += 1
                            if "*/" in stripped:
                                in_block_comment = False
                        elif stripped.startswith("//"):
                            comment_lines += 1
                        elif stripped.startswith("/*"):
                            comment_lines += 1
                            if not "*/" in stripped:
                                in_block_comment = True

                    row[baseline] = comment_lines
            except Exception as e:
                print(f"[Erro ao ler arquivo] {java_file}: {e}")
                row[baseline] = None
        else:
            row[baseline] = None

    results.append(row)

df = pd.DataFrame(results)

script_dir = os.path.dirname(os.path.abspath(__file__))

output_path = os.path.join(script_dir, "loc_comment_per_snippet.csv")

df.to_csv(output_path, index=False)
print("[✓] Arquivo 'comment_loc_per_snippet.csv' gerado com sucesso.")
