import csv
import os
from pathlib import Path
import pandas as pd
import sys

csv_path = "issues_sample_total.csv"
base_data_dir = r"../../Chapter 3/Replication Package/Step 4 - Code Readability Issues/1 - Extract Issues/data"
output_base = r"data"

baseline_map = {
    "Gemini": "Gemini",
    "stackoverflow": "stackOverflow",
    "chatgpt": "ChatGpt",
    "chatgpt2025": "ChatGpt2025",
    "deepseek": "DeepSeek"
}

with open(csv_path, newline='', encoding="utf-8") as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        snippet_id = row["snippet_id"]

        for source, folder_name in baseline_map.items():
            violations = row[source].strip()
            if not violations:
                continue

            violation_list = [v.strip() for v in violations.split(",") if v.strip()]
            snippet_path = Path(base_data_dir) / snippet_id / folder_name

            if not snippet_path.exists():
                print(f"Pasta não encontrada: {snippet_path}")
                sys.exit(1)

            java_file = next(snippet_path.glob("*.java"), None)
            if not java_file:
                print(f"Arquivo Java não encontrado em: {snippet_path}")
                sys.exit(1)

            with open(java_file, encoding="utf-8") as jf:
                java_code = jf.read()

            sonar_file = next(snippet_path.glob("sonarLintAnalysis_version_10.22.0.81232_*.csv"), None)
            if not sonar_file:
                print(f"Arquivo SonarLint não encontrado em: {snippet_path}")
                sys.exit(1)

            matching_descriptions = []
            colunas = ["rule key", "start line", "end line", "severity", "message", "type"]

            df = pd.read_csv(sonar_file, sep=",", names=colunas,header=0, usecols=range(len(colunas)),dtype=str)            
            df.columns = df.columns.str.strip()             

            for v in violation_list:                
                matches = df[df['rule key'].isin(violation_list)]
                for _, row_ in matches.iterrows():
                    rule_key = row_["rule key"]
                    message = row_["message"]
                    start = row_["start line"]
                    end = row_["end line"]
                    matching_descriptions.append(
                        f"rule key = {rule_key} message = {message}, start line = {start}, end line = {end}"
                    )

            prompt = (
                f"Given the following Java code snippet:\n{java_code}\n\n"
                f"the following improvements are recommended: {', '.join(matching_descriptions)}.\n"
                f"Please provide a revised version of the code snippet that applies the recommended improvements. Only the revised code snippet, without additional text."
            )

            output_dir = Path(output_base) / f"{snippet_id}" / f"{folder_name}"
            output_dir.mkdir(parents=True, exist_ok=True)

            output_file = output_dir / "prompt.txt"
            with open(output_file, "w", encoding="utf-8") as out:
                out.write(prompt)

            print(f"Prompt salvo em: {output_file}")
