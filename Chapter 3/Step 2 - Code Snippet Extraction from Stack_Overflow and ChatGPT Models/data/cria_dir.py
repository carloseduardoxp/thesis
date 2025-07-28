import os
import re

def criar_subpastas_em_diretorios_validos(diretorio_raiz='.'):
    for raiz, subdirs, _ in os.walk(diretorio_raiz):
        for subdir in subdirs:
            caminho_completo = os.path.join(raiz, subdir)

            # Verifica se o diretório começa com um número entre 2 e 357
            match = re.match(r'^(\d+)', subdir)
            if match:
                numero = int(match.group(1))
                if 2 <= numero <= 357:
                    for nome_pasta in ['ChatGpt2025', 'DeepSeek', 'Gemini']:
                        nova_pasta = os.path.join(caminho_completo, nome_pasta)
                        if not os.path.exists(nova_pasta):
                            os.makedirs(nova_pasta)
                            print(f'Criada pasta: {nova_pasta}')

if __name__ == "__main__":
    criar_subpastas_em_diretorios_validos()
