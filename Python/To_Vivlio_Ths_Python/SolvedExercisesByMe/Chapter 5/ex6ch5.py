"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

aList = []
for i in range(10):
    aList.append(randint(0, 10))

print('Lista: ', aList)

#MO, max, min, success rate, sort with 2 ways
#1st Pre-Build Functions

max = max(aList)
min = min(aList)

print('MAX: ', max, 'MIN: ', min)
sum = sum(aList)
MO = sum / len(aList)
print('MO: ', MO)

succ = [aList[i] for i in range(len(aList)) if aList[i] >= 5]
succRate = len(succ) / len(aList) * 100
print('Success rate: ', succRate)

bList = sorted(aList, reverse = True)
print('List sorted descending: ', bList)

#2nd with manual procedures
sum = aList[0]
succ = 1 if aList[0] >= 5 else 0
max = aList[0]
min = aList[0]
for i in range(1, len(aList)):
    if aList[i] > max:
        max = aList[i]
    
    if aList[i] < min:
        min = aList[i]
    
    sum += aList[i]
    if aList[i] >= 5:
        succ += 1

print('MAX: ', max, 'MIN: ', min)
MO = sum / len(aList)
succ = succ / len(aList) * 100
print('MO: ', MO, 'Success Rate: ', succ)

bList = []
for i in range(len(aList)):
    bList.append(aList[i])

for i in range(1, len(bList)):
    for j in range(len(bList) - 1, i - 1, -1):
        if bList[j] > bList[j - 1]:
            temp = bList[j]
            bList[j] = bList[j - 1]
            bList[j - 1] = temp

print('List sorted by descending: ', bList)