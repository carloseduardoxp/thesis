import matplotlib.pyplot as plt
from collections import Counter
import pandas as pd

import os

script_dir = os.path.dirname(os.path.abspath(__file__))

positions = os.path.join(script_dir, "top-ranked.csv")
positions_df = pd.read_csv(positions)

positions = positions_df.iloc[:, 0].tolist()

counter = Counter(positions)

sorted_positions = sorted(counter.items())

x = [f'Top {rank}' for rank, _ in sorted_positions]
y = [count for _, count in sorted_positions]

plt.figure(figsize=(10, 6))
plt.bar(x, y)
plt.xlabel("CROKAGE Rank (Top N)")
plt.ylabel("Number of Selected Snippets")
plt.title("Distribution of Selected Stack Overflow Posts by CROKAGE Rank")
plt.xticks(rotation=45)
plt.tight_layout()
plt.grid(axis='y', linestyle='--', alpha=0.7)

plt.show()
