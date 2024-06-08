"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}

for i in range(1, 10):
    dict1[i] = randint(10, 100)

list1 = [(i, dict1[i]) for i in dict1.keys()]
print(list1)

#list1.sort()
list1 = sorted(dict1.items(), key = lambda item: item[1])
print(f'Min value of this dictionary: {list1[0][1]}\nMax value of this dictionary: {list1[len(list1) - 1][1]}')