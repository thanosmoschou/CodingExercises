"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = ((1, 3), (5, 5), (7, 8))

tup2 = ()
for item in range(2):
    tup2 += (tup[0][item], tup[1][item], tup[2][item])

print(*tup2)