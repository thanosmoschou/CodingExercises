"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#implementation with for loops
sumOdd = 0
sumEven = 0

aList = list(range(13))
print(aList)

for i in range(len(aList)):
    if i % 2 == 0:
        sumEven += aList[i]
    else:
        sumOdd += aList[i]

print("Sum at odd places: ", sumOdd)
print("Sum at odd even: ", sumEven)