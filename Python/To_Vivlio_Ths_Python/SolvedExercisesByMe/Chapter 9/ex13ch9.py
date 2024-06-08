"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}

for i in range(10):
    dict1[i] = randint(0, 100)

print(dict1)

doubleVal = False
for key in dict1.keys(): #gia kathe timi sozo to kleidi kai tin timi.
    pos = key
    val = dict1[pos]
    for key2 in dict1.keys(): #tora tha psakso pali thn timi an yparxei ksana. Prosoxi thelo to kleidi na einai diaforetiko apo to arxiko mou
        if key2 != pos and dict1[key2] == dict1[pos]:
            doubleVal = True
            break
    if doubleVal:
        break

if doubleVal:
    print("There are double values in this dictionary.")
else:
    print("There are not double values in this dictionary.")