import os
import re

arquivo_tsv = 'Java - Open Coding - samples human evaluation - all.tsv'
pasta_base = 'samples'
os.makedirs(pasta_base, exist_ok=True)

# Colunas esperadas
coluna_id = 'id'
coluna_desc = 'developer description'
coluna_before = 'code before'
coluna_after = 'code after'

# Função para checar se uma linha começa com um ID numérico
def linha_comeca_com_id(linha):
    return re.match(r'^\d+\t', linha) is not None

# Leitura manual, acumulando linhas até encontrar próxima linha de ID
with open(arquivo_tsv, encoding='latin1') as f:
    linhas = f.readlines()

cabecalho = linhas[0].strip().split('\t')
idx_id = cabecalho.index(coluna_id)
idx_desc = cabecalho.index(coluna_desc)
idx_before = cabecalho.index(coluna_before)
idx_after = cabecalho.index(coluna_after)

registro_buffer = []
for linha in linhas[1:]:
    if linha_comeca_com_id(linha) and registro_buffer:
        registro_completo = ''.join(registro_buffer).strip()
        campos = registro_completo.split('\t')

        if len(campos) >= max(idx_id, idx_desc, idx_before, idx_after) + 1:
            id_str = campos[idx_id].strip()
            dev_desc = campos[idx_desc].strip()
            code_before = campos[idx_before].strip()
            code_after = campos[idx_after].strip()

            if id_str and dev_desc:
                prompt = (
                    f"Based on this pull request with the developer description: {dev_desc}, "
                    f"the code was changed by the developer from {code_before} (if dont have code before, the code wasnt exist yet) to {code_after}, (if dont have code after, the code was removed) "
                    "please, provide the appropriate label that represents the code readability improvement described and performed by the developer. No explanations, only the name of the appropriate label."
                )

                pasta_amostra = os.path.join(pasta_base, id_str)
                os.makedirs(pasta_amostra, exist_ok=True)

                with open(os.path.join(pasta_amostra, 'prompt.txt'), 'w', encoding='utf-8') as f_out:
                    f_out.write(prompt)

        registro_buffer = [linha]
    else:
        registro_buffer.append(linha)

# Último registro
if registro_buffer:
    registro_completo = ''.join(registro_buffer).strip()
    campos = registro_completo.split('\t')

    if len(campos) >= max(idx_id, idx_desc, idx_before, idx_after) + 1:
        id_str = campos[idx_id].strip()
        dev_desc = campos[idx_desc].strip()
        code_before = campos[idx_before].strip()
        code_after = campos[idx_after].strip()

        if id_str and dev_desc:
            prompt = (
                f"Based on this pull request with the developer description: {dev_desc}, "
                f"the code was changed by the developer from {code_before} to {code_after}, "
                "please, provide the appropriate label that represents the code readability improvement described and performed by the developer. No explanations, only the name of the appropriate label"
            )

            pasta_amostra = os.path.join(pasta_base, id_str)
            os.makedirs(pasta_amostra, exist_ok=True)

            with open(os.path.join(pasta_amostra, 'prompt.txt'), 'w', encoding='utf-8') as f_out:
                f_out.write(prompt)

print("Geração de prompts com parsing manual finalizada.")
