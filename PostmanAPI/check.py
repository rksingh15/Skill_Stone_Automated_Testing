import json

# filepath: c:\Users\DELL\Desktop\CSEAPI\validate_json.py
try:
    with open('c:\\Users\\DELL\\Desktop\\CSEAPI\\library.json', 'r') as file:
        data = json.load(file)
    print("JSON is valid")
except json.JSONDecodeError as e:
    print(f"JSON is invalid: {e}")