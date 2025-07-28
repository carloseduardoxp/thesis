import google.generativeai as genai
import os
import time
from pathlib import Path

API_KEY = os.getenv("GOOGLE_API_KEY", "YOUR_KEY")  

if not API_KEY:
    raise ValueError("Você precisa definir a API key do Gemini")

genai.configure(api_key=API_KEY)

MODEL = "gemini-2.5-pro"
TEMPERATURE = 0.0
SYSTEM_PROMPT = """You are a software developer specialized in the Java programming language, with expertise in improving the readability of the code based on a list of recommendations."""

base_path = Path(r"../data")

def query_gemini(user_prompt):
    try:
        model = genai.GenerativeModel(MODEL)

        full_prompt = f"{SYSTEM_PROMPT}\n\n{user_prompt}"

        response = model.generate_content(full_prompt, generation_config={
            "temperature": TEMPERATURE,
        })

        return response.text.strip()
    except Exception as e:
        print(f"Erro ao consultar a API Gemini: {e}")
        return "ERROR"

def save_response(folder_llm_affected, response):
    folder_llm_affected = Path(folder_llm_affected)
    output_folder = folder_llm_affected / "Gemini"
    output_folder.mkdir(parents=True, exist_ok=True)
    java_file = output_folder / "resposta.java"
    with open(java_file, "w", encoding="utf-8") as f:
        f.write(response)

def process():
    for folder_query_id in sorted(base_path.iterdir()):
        if folder_query_id.is_dir():
            for folder_llm_affected in sorted(folder_query_id.iterdir()):
                if folder_llm_affected.is_dir():
                    prompt_file = folder_llm_affected / "prompt.txt"
                    if prompt_file.exists():
                        print(f"\n===== Prompt em: {folder_llm_affected.name} =====")
                        with open(prompt_file, encoding="utf-8") as f:
                            prompt_content = f.read()
                            response = query_gemini(prompt_content)
                            save_response(folder_llm_affected, response)
                            time.sleep(1)
                    else:
                        print(f"[AVISO] prompt.txt não encontrado em: {folder_llm_affected.name}")
                        exit(1)

if __name__ == "__main__":
    if not base_path.exists():
        print(f"Diretório não encontrado: {base_path}")
        exit(1)
    process()
