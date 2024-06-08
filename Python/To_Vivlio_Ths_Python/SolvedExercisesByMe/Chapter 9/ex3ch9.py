"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from math import gcd


import math

dict1 = {}
dict1 = dict1.fromkeys(key for key in range(20))
print(dict1)

for key in dict1.keys():
    dict1[key] = gcd(key, key + 1)

print(dict1)