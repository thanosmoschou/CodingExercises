"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = (1, 4, 6, 43, 1)
palind = True

for item in range(len(tup) // 2):
    if tup[item] != tup[len(tup) - item - 1]:
        palind = False
        break

if palind:
    print("Palindrome")
else:
    print("Not palindrome")