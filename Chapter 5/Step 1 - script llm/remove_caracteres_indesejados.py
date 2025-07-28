import os

base_dir = r"data"

for root, dirs, files in os.walk(base_dir):
    for file in files:
        if file.endswith(".java"):
            file_path = os.path.join(root, file)
            with open(file_path, 'r', encoding='utf-8') as f:
                lines = f.readlines()

            if lines and lines[0].strip() == "```java":                
                lines = lines[1:]
                if lines and lines[-1].strip() == "```":
                    lines = lines[:-1]

                with open(file_path, 'w', encoding='utf-8') as f:
                    f.writelines(lines)
