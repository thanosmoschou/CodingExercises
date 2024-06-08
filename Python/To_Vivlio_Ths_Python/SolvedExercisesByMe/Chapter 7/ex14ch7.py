"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = ((2, 4), 3, (4, 2), 'F')

doubleElem = False

for item1 in range(len(tup)):
    for item2 in range(item1 + 1, len(tup)):
        if tup[item1] == tup[item2]:
            doubleElem = True
            break
    if doubleElem: #gia na min sunexisei na psaxnei tzampa
        break

if doubleElem:
    print("There are double elements on this tupple")
else:
    print("There are no double elements on this tupple")