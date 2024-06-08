"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter your message here: ")

s1 = set()
s1.update(message)
print(f'Different character in this message: {s1}')