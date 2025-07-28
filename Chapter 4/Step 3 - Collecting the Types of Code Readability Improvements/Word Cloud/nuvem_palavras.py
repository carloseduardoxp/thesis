import os
import spacy
from wordcloud import WordCloud, STOPWORDS
import matplotlib.pyplot as plt
from collections import Counter

diretorio_base = os.path.dirname(os.path.abspath(__file__))

nlp = spacy.load("en_core_web_sm")

entrada = os.path.join(diretorio_base, 'nuvem_java.txt')
#entrada = os.path.join(diretorio_base, 'nuvem_python.txt')

with open(entrada, 'r', encoding='utf-8') as f:
    texto_total = f.read()

stopwords_personalizadas = {
    ''
}

stopwords = STOPWORDS.union(stopwords_personalizadas)

doc = nlp(texto_total.lower())
palavras_filtradas = []

for token in doc:
    if token.is_alpha and token.lemma_ not in stopwords and len(token.lemma_) > 3:
        palavras_filtradas.append(token.lemma_)

contador = Counter(palavras_filtradas)
texto_processado = ' '.join(palavras_filtradas)

nuvem = WordCloud(
    width=800,
    height=400,
    background_color='white',
    stopwords=stopwords
).generate_from_frequencies(contador)

plt.figure(figsize=(15, 7))
plt.imshow(nuvem, interpolation='bilinear')
plt.axis('off')
plt.show()
