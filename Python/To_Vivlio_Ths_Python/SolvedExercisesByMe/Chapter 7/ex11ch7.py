"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

list1 = [(3, 4), (4, 5)]
list2 = []

for item in range(len(list1)):
    for item2 in range(2):
        list2.append(list1[item][item2])

print(list2)