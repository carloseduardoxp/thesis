import matplotlib.pyplot as plt
from collections import Counter
from datetime import datetime

def contar_prs_por_ano(caminho_arquivo):
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
    return anos, contagem_anos

# Processa os dois arquivos
anos_python, contagem_python = contar_prs_por_ano('datas_python.txt')
anos_java, contagem_java = contar_prs_por_ano('datas_java.txt')

# Faixa de anos combinada
ano_min = min(min(anos_python), min(anos_java))
ano_max = max(max(anos_python), max(anos_java))
todos_os_anos = list(range(ano_min, ano_max + 1))

# Quantidades por ano
quantidades_python = [contagem_python.get(ano, 0) for ano in todos_os_anos]
quantidades_java = [contagem_java.get(ano, 0) for ano in todos_os_anos]

# Cria os gráficos
fig, axs = plt.subplots(2, 1, figsize=(10, 8), sharex=True)

axs[0].bar(todos_os_anos, quantidades_python, color='skyblue')
axs[0].set_title('Python: Readability-Focused PRs by Year')
axs[0].set_ylabel('PRs')
axs[0].grid(True, axis='y')

axs[1].bar(todos_os_anos, quantidades_java, color='lightgreen')
axs[1].set_title('Java: Readability-Focused PRs by Year')
axs[1].set_xlabel('Year')
axs[1].set_ylabel('PRs')
axs[1].grid(True, axis='y')
axs[1].set_xticks(todos_os_anos)

plt.tight_layout()
plt.show()
