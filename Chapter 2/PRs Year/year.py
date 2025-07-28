import matplotlib.pyplot as plt
from collections import Counter
from datetime import datetime

caminho_arquivo = 'datas.txt'

with open(caminho_arquivo, 'r') as f:
    linhas = f.readlines()

anos = []
for linha in linhas:
    try:
        data = datetime.strptime(linha.strip(), '%Y-%m-%d %H:%M:%S')
        anos.append(data.year)
    except ValueError:
        continue

contagem_anos = Counter(anos)

ano_min = min(anos)
ano_max = max(anos)
todos_os_anos = list(range(ano_min, ano_max + 1))
quantidades = [contagem_anos.get(ano, 0) for ano in todos_os_anos]

plt.figure(figsize=(8, 5))
plt.bar(todos_os_anos, quantidades)
plt.xlabel('Year')
plt.ylabel('Pull Requests (PR)')
plt.title('Code Readability-Focused PRs By Year')
plt.xticks(todos_os_anos)  
plt.grid(True, axis='y')
plt.tight_layout()
plt.show()