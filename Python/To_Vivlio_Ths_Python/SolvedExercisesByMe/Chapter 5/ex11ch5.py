"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from unicodedata import decimal


def breakTheNum(number):
    sumNum = 0
    while number % 10 != 0 and number // 10 != 0:
        sumNum += (number % 10)
        number = number // 10
    return sumNum

threeDigitsA = []
threeDigitsB = []
sumOfThreeDig = []
for i in range(100, 1000):
    threeDigitsA.append(i)
    threeDigitsB.append(i)
    sumOfThreeDig.append(breakTheNum(i))

#print("Sum of digits: ", sumOfThreeDig)

for i in range(1, len(threeDigitsB)):
    for j in range(len(threeDigitsB) - 1, i - 1, -1): 
        if(sumOfThreeDig[j] >= sumOfThreeDig[j - 1]):
            tempN = threeDigitsB[j]
            threeDigitsB[j] = threeDigitsB[j - 1]
            threeDigitsB[j - 1] = tempN

            tempD = sumOfThreeDig[j]
            sumOfThreeDig[j] = sumOfThreeDig[j - 1]
            sumOfThreeDig[j - 1] = tempD


# print("Initial List: ", threeDigitsA)
print("Sorted List by the criteria: ", threeDigitsB)