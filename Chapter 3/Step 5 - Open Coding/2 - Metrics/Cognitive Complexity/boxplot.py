import pandas as pd
import os
import matplotlib.pyplot as plt

script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, "cognitive_occurrences_total.csv")

df = pd.read_csv(file_path)

order = ["Gemini", "stackoverflow", "chatgpt", "chatgpt2025", "deepseek"]

plt.figure(figsize=(10, 6))
df[order].boxplot()
plt.title("Cognitive Complexity Distribution by Baseline")
plt.ylabel("Score - Cognitive Complexity")
plt.ylim(0, 20)
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()
