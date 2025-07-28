import os
from pathlib import Path

base_path = Path(r"data")

leaf_dirs_without_java = []

for root, dirs, files in os.walk(base_path):
    root_path = Path(root)
    
    if not dirs:
        java_files = [f for f in files if f.endswith(".java")]
        if not java_files:
            leaf_dirs_without_java.append(root_path)

print("Diretórios folha sem arquivos .java:")
for path in leaf_dirs_without_java:
    print(path)
