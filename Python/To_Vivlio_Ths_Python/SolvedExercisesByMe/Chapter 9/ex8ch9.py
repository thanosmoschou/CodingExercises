"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

dict1 = {}

for key in range(1, 6):
    dict1[key] = key ** 2

sum = 0
prod = 1

for key in dict1.keys():
    sum += dict1[key]
    prod *= dict1[key]

print("Sum: {0:2d}\nProduct: {1: 2d}".format(sum, prod))