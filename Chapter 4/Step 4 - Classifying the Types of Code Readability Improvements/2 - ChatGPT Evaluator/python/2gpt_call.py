import openai
import os
import time

openai.api_key = "YOUR_OPEN_AI_KEY"

MODEL = "gpt-4.1"
TEMPERATURE = 0.0
TOP_P = 1.0
MAX_TOKENS = 16000

with open("python_labels.txt", "r", encoding="utf-8") as f:
    labels = f.read().strip()

SYSTEM_PROMPT = (
    f"You are a software developer specialized in Python, skilled in reading GitHub Pull Request texts "
    f"written by other developers and labeling the code readability improvements described by them using one of the following labels: {labels}. "
    f"You may also suggest new labels only if none of the provided labels accurately represents the improvement described by the developer."
)

# Caminho da pasta com os samples
BASE_DIR = "samples"

def query_gpt4o(user_prompt):
    try:
        response = openai.chat.completions.create(
            model=MODEL,
            temperature=TEMPERATURE,
            top_p=TOP_P,
            max_tokens=MAX_TOKENS,
            messages=[
                {"role": "system", "content": SYSTEM_PROMPT},
                {"role": "user", "content": user_prompt}
            ]
        )
        return response.choices[0].message.content.strip()
    except Exception as e:
        print(f"Erro ao consultar a API: {e}")
        return "ERROR"

def process_prompts():
    for pasta in sorted(os.listdir(BASE_DIR)):
        caminho_pasta = os.path.join(BASE_DIR, pasta)
        prompt_path = os.path.join(caminho_pasta, "prompt.txt")
        response_path = os.path.join(caminho_pasta, "response.txt")

        # Verifica se o prompt existe e se ainda não foi gerado response.txt
        if os.path.isdir(caminho_pasta) and os.path.exists(prompt_path) and not os.path.exists(response_path):
            with open(prompt_path, "r", encoding="utf-8") as f:
                user_prompt = f.read().strip()

            print(f"Enviando prompt da pasta {pasta} para o modelo...")
            resposta = query_gpt4o(user_prompt)

            with open(response_path, "w", encoding="utf-8") as f:
                f.write(resposta)

            time.sleep(1)  

if __name__ == "__main__":
    process_prompts()