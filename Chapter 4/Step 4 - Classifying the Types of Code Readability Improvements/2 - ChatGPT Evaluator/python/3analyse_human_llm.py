import os
import re
import csv

ARQUIVO_HUMANO = "Python - Open Coding - samples human evaluation - all.tsv"
PASTA_SAMPLES = "samples"
ARQUIVO_SAIDA = "comparacao_labels.csv"

# Função para detectar início de novo registro baseado na coluna id
def linha_comeca_com_id(linha):
    return re.match(r'^\d+\t', linha) is not None

# Leitura bruta do arquivo, preservando quebras de linha
with open(ARQUIVO_HUMANO, mode='r', encoding='utf-8') as f:
    linhas = f.readlines()

# Cabeçalho e índice da coluna de label
cabecalho = linhas[0].strip().split('\t')
idx_id = cabecalho.index('id')
idx_label = cabecalho.index('human label')

# Prepara a escrita da saída
with open(ARQUIVO_SAIDA, mode='w', encoding='utf-8', newline='') as saida:
    writer = csv.writer(saida)
    writer.writerow(['ID', 'Human Label', 'Response.txt', 'Match'])

    buffer = []

    for linha in linhas[1:]:
        if linha_comeca_com_id(linha) and buffer:
            registro = ''.join(buffer).strip()
            campos = registro.split('\t')

            if len(campos) > idx_label:
                id_str = campos[idx_id].strip()
                human_label = campos[idx_label].strip()
                response_path = os.path.join(PASTA_SAMPLES, id_str, 'response.txt')

                if os.path.exists(response_path):
                    with open(response_path, 'r', encoding='utf-8') as r:
                        resposta = r.read().strip()
                        match = "YES" if human_label.lower() in resposta.lower() else "NO"
                else:
                    resposta = "(Arquivo não encontrado)"
                    match = "NO"

                writer.writerow([id_str, human_label, resposta, match])

            buffer = [linha]
        else:
            buffer.append(linha)

    # Último registro
    if buffer:
        registro = ''.join(buffer).strip()
        campos = registro.split('\t')

        if len(campos) > idx_label:
            id_str = campos[idx_id].strip()
            human_label = campos[idx_label].strip()
            response_path = os.path.join(PASTA_SAMPLES, id_str, 'response.txt')

            if os.path.exists(response_path):
                with open(response_path, 'r', encoding='utf-8') as r:
                    resposta = r.read().strip()
                    match = "YES" if human_label.lower() in resposta.lower() else "NO"
            else:
                resposta = "(Arquivo não encontrado)"
                match = "NO"

            writer.writerow([id_str, human_label, resposta, match])

print("Comparação finalizada: saída salva em comparacao_labels.csv")
