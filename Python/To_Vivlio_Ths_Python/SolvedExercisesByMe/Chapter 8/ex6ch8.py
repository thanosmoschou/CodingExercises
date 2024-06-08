"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from subprocess import list2cmdline


list1 = list(x for x in range(0, 100, 4))
list2 = list(x for x in range(0, 50, 4))

s1 = set(list1)
s2 = set(list2)
print(f's1: {s1}', f's2: {s2}', sep = '\n')

s3 = s1.intersection(s2)
print(f'Intersection of s1 and s2: {s3}')