"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = (-1, 1, 2, 3, 4)
indexEqualToValue = True

for item in range(len(tup)):
    if item != tup[item]:
        indexEqualToValue = False
        break

if indexEqualToValue:
    print("Indexes are equal to the exact values of this tupple.")
else:
    print("Indexes are not equal to the exact values of this tupple.")