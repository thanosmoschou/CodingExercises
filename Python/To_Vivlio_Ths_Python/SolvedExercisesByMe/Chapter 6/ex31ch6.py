"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = "AAAAABBBBDDDDKJJJJ"

prevChar = message[0]
ctrChar = 0
compressed = ''

for char in message:
    if char == prevChar:
        ctrChar += 1
    else:
        compressed = compressed + str(ctrChar) + prevChar
        ctrChar = 1 #found already a new character
        prevChar = char
else:
    compressed = compressed + str(ctrChar) + prevChar
    
print(f'Compressed Message: {compressed}')