import nltk

from collections import Counter
from nltk.util import ngrams
from nltk.corpus import stopwords
import re

# ===============================
# CONFIGURAÇÃO
# ===============================

# Substitua pelo caminho do seu arquivo de queries (1 por linha)
arquivo_entrada = 'c:\\Users\\carlo\\Downloads\\VEM_LLMs_Readability\\Replication Package\\Step 1 - Selecting Developer Input Queries\\data\\queries.txt'

# Ignorar stopwords no 1-gram e 2-gram?
REMOVER_STOPWORDS = True

# ===============================
# FUNÇÕES AUXILIARES
# ===============================

def preprocess(text):
    # Remove pontuação e coloca em minúsculas
    text = re.sub(r'[^\w\s]', '', text.lower())
    return nltk.word_tokenize(text)

def contar_ngrams(queries, n, stopwords_set=None):
    counter = Counter()
    for query in queries:
        tokens = preprocess(query)
        if stopwords_set and n in (1, 2):
            tokens = [t for t in tokens if t not in stopwords_set]
        for gram in ngrams(tokens, n):
            counter[gram] += 1
    return counter.most_common(20)

# ===============================
# EXECUÇÃO
# ===============================

# Lê as queries do arquivo
with open(arquivo_entrada, 'r', encoding='utf-8') as f:
    queries = [linha.strip() for linha in f if linha.strip()]

stopwords_set = set(stopwords.words('english')) if REMOVER_STOPWORDS else None

# Gera top-10 n-grams
print("\nTop N-grams:")
for n in range(1, 5):
    print(f"\nTop 10 {n}-grams:")
    top_ngrams = contar_ngrams(queries, n, stopwords_set)
    for rank, (ngram, freq) in enumerate(top_ngrams, start=1):
        print(f"{rank:2}. {' '.join(ngram)} ({freq})")
