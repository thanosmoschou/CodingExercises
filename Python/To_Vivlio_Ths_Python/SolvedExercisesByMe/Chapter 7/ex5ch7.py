"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = ([1, 3, 5], [4, 8, 9])

for item in range(3):
    temp = tup[0][item]
    tup[0][item] = tup[1][item]
    tup[1][item] = temp
print(tup)