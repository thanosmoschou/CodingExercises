"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

list1 = [(), (2,3), (), ()]

for item in range(len(list1)):
    if list1[item] == ():
        list1[item] = 'None'

print(list1)