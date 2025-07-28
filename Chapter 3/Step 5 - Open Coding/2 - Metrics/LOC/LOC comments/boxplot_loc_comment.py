import pandas as pd
import os
import matplotlib.pyplot as plt

from io import StringIO

script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, "loc_comment_per_snippet.csv")

df = pd.read_csv(file_path)

plt.figure(figsize=(10, 6))
df.drop(columns="snippet_id").boxplot()
plt.title("LOC Comments Distribution by Baseline")
plt.ylabel("Lines of Code (LOC)")
plt.ylim(0, 50)
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()
