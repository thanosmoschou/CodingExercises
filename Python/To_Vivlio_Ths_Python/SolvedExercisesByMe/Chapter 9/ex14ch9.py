"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}

for i in range(10):
    dict1[i] = randint(0, 10)

print(dict1)
list1 = [(i, dict1[i]) for i in dict1.keys()] #perasa se lista tis times(pleiades) gia na kano metatropes

for key in list1: #gia kathe timi sozo to kleidi kai tin timi.
    doubleVal = False
    pos = key[0]
    val = key[1]
    for key2 in list1: #tora tha psakso pali thn timi an yparxei ksana. Prosoxi thelo to kleidi na einai diaforetiko apo to arxiko mou
        if key2[0] != pos and key2[1] == val:
            doubleVal = True
            break
    if doubleVal:
        for i in list1:
            if i[0] != pos and i[1] == val:
                list1.remove(i)

dict1 = dict(list1) #pernao tis times pali sto leksiko
print(dict1)