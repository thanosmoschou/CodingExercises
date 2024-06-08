"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

aList = []

for i in range(20):
    aList.append(randint(0, 30))

print('Lista A: ', aList)

bList = []

for i in range(len(aList)):
    if aList[i] != 0:
        bList.append(aList[i])

print('Lista me mono tous mh mhdenikous arithmous: ', bList)