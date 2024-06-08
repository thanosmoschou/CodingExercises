"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

with open("ex5ch12.dat", "r") as filename:
    name = "ex5ch12.py"
    line = filename.readline(9)
    hyperlinkCtr = 0
    while line:
        if line == "<a href =":
            hyperlinkCtr += 1
        
        line = filename.readline(9)

print(f'Hyperlinks in {name}: {hyperlinkCtr}')