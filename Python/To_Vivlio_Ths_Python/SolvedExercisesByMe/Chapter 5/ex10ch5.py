"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import array

tempList = []

for i in range(25):
    tempNum = int(input("Dwse enan arithmo gia ton pinaka 5x5: "))
    tempList.append(tempNum)


numbers = array.array('i', tempList)
sumNum = 0

for i in range(len(tempList)):
    sumNum += numbers[i]

print("Sum: ", sumNum)