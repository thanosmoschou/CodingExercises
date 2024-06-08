"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

lst1 = [(1, 2), 3, 'D', (4,), 90, ()]
lst2 = []

lst2 += [lst1[0], lst1[3]]
print(*lst2)