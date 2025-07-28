import pandas as pd
from sklearn.metrics import cohen_kappa_score
import os

script_dir = os.path.dirname(os.path.abspath(__file__))

adriano_path = os.path.join(script_dir, "Adriano.csv")
carlos_path = os.path.join(script_dir, "Carlos.csv")

adriano_df = pd.read_csv(adriano_path)
carlos_df = pd.read_csv(carlos_path)

kappa_before = cohen_kappa_score(adriano_df['before'], carlos_df['before'])
kappa_after = cohen_kappa_score(adriano_df['after'], carlos_df['after'])

print("Kappa BEFORE:", kappa_before)
print("Kappa AFTER:", kappa_after)