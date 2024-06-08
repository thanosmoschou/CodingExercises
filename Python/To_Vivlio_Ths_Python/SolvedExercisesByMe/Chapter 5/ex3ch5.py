"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

aList = []
for i in range(10):
    aList.append(randint(0, 12))

print(aList)

searchNum = int(input('Dwse enan arithmo pou psaxneis: '))

bList = [i for i in range(len(aList)) if aList[i] == searchNum]
print('O arithmos: ', searchNum, 'vrethike se autes tis theseis: ', bList)