"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import csv

list = []
with open('ex11ch12.dat', 'r') as readFile:
    data = csv.reader(readFile, delimiter = ',')
    for item in data:
        list.append(item)

print(list)