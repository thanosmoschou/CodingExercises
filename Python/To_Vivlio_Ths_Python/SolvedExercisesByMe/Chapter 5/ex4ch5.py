"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

aList = []

for i in range(10):
    aList.append(randint(0, 10))

print('Vathmoi mathitwn sto diasthma [0...10]:', aList)
bList = []

for i in range(11):
    bList.append(aList.count(i))

print('Syxnothta emfanisis vathmon apo 0...10: ', bList)