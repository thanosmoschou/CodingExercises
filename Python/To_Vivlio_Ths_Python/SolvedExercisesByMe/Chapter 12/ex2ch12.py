"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

try:
    name = 'ex2ch12.dat'
    filename = open('ex2ch12.dat', 'r')
except FileNotFoundError:
    print(f'Problem with file: {name}')
else:
    data = filename.read()
    charCtr = 0

    for item in data:
        charCtr += 1

    filename.close()
    print(f'Total characters in {name}: {charCtr}')