import os

def excluir_csvs(diretorio_raiz='.'):
    for raiz, _, arquivos in os.walk(diretorio_raiz):
        for nome_arquivo in arquivos:
            if nome_arquivo.lower().endswith('.csv'):
                caminho_completo = os.path.join(raiz, nome_arquivo)
                try:
                    os.remove(caminho_completo)
                    print(f"Removed: {caminho_completo}")
                except Exception as e:
                    print(f"Error on remove {caminho_completo}: {e}")

if __name__ == "__main__":
    excluir_csvs()
