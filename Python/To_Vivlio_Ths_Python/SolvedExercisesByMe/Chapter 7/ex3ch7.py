"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = ((1, 3, 5), (5, 7, 8))

dist = 0
for item in range(3):
    dist += (tup[0][item] - tup[1][item]) ** 2
dist = dist ** 0.5
print(dist)