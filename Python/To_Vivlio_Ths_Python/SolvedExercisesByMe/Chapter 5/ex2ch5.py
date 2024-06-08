"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

aList = list(range(15))
print(aList)

bList = [x**2 for x in aList if x % 2 != 0]
print(bList)