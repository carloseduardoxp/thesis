import os
import pandas as pd
import matplotlib.pyplot as plt

diretorio_base = os.path.dirname(os.path.abspath(__file__))

entrada = os.path.join(diretorio_base, 'boxplot_data_python.csv')

df = pd.read_csv(entrada)

df['stars'] = pd.to_numeric(df['stars'], errors='coerce')
df['pullRequests'] = pd.to_numeric(df['pullRequests'], errors='coerce')
df['collaborators'] = pd.to_numeric(df['collaborators'], errors='coerce')

df = df.dropna(subset=['stars', 'pullRequests', 'collaborators'])

plt.figure(figsize=(10, 6))
df[['stars', 'pullRequests', 'collaborators']].boxplot()

fig, axs = plt.subplots(1, 3, figsize=(15, 5))

df.boxplot(column='stars', ax=axs[0])
axs[0].set_title('Stars')
axs[0].set_ylim(0, 20000)

df.boxplot(column='pullRequests', ax=axs[1])
axs[1].set_title('Pull Requests')
axs[1].set_ylim(0, 20000)

df.boxplot(column='collaborators', ax=axs[2])
axs[2].set_title('Collaborators')
axs[2].set_ylim(0, 500)

plt.tight_layout()
plt.show()
