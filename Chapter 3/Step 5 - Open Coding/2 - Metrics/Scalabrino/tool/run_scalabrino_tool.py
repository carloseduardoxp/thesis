import os
import subprocess
import pandas as pd

script_dir = os.path.dirname(os.path.abspath(__file__))

BASE_DIR = r"C:\Users\carlo\Downloads\VEM_LLMs_Readability\Replication Package\Step 4 - Code Readability Issues\1 - Extract Issues\data"
JAR_FILE = os.path.join(script_dir, "rsm.jar")
BASELINES = ["stackoverflow", "chatgpt", "chatgpt2025", "deepseek", "Gemini"]

results = []

for snippet_id in range(2, 358):
    snippet_path = os.path.join(BASE_DIR, str(snippet_id))

    if not os.path.isdir(snippet_path):
        continue

    for baseline in BASELINES:
        baseline_path = os.path.join(snippet_path, baseline)

        if not os.path.isdir(baseline_path):
            continue

        for file_name in os.listdir(baseline_path):
            if file_name.endswith(".java"):
                java_file = os.path.join(baseline_path, file_name)
                
                try:
                    result = subprocess.run(
                        ["java", "-jar", JAR_FILE, java_file],
                        capture_output=True,
                        text=True,
                        timeout=10
                    )
                    
                    output = result.stdout.strip()
                    parts = output.strip().split('\t')
                    readability_score = float(parts[2])

                    print(f"Snippet {snippet_id}, {baseline}, score: {readability_score}")

                    results.append({
                        "snippet_id": snippet_id,
                        "baseline": baseline,
                        "readability_score": readability_score
                    })

                except Exception as e:
                    print(f"Erro ao processar {java_file}: {e}")

# Salva resultados no CSV
df_result = pd.DataFrame(results)
output_csv = os.path.join(script_dir, "scalabrino.csv")
df_result.to_csv(output_csv, index=False)
