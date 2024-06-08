"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint


def checkIfIsNum1(func):
    def checkIfIsNum2(elem, list1):
        isNum = True
        for item in list1:
            if str(item).isalpha(): #i make it string to check if it is number or letter. Only in string i have these methods
                isNum = False
                break
        if isNum:
            return f'All items in list are numbers. The number {elem} is included in the list {func(elem, list1)} times'
        return f'This list contains some letters. The element {elem} is included in the list {func(elem, list1)} times'
    return checkIfIsNum2

@checkIfIsNum1
def findElem(elem, list1):
    timesFound = 0
    for item in list1:
        if elem == item:
            timesFound += 1
    return timesFound

list1 = [randint(0, 10) for x in range(10)]
#list1.append('a')
elem = randint(0, 10)

print(f'The list is: {list1}', findElem(elem, list1), sep = '\n')