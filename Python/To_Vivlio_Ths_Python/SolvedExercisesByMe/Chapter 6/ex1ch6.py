"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter a message: ")

for char in message:
    print(char + ":", ord(char))