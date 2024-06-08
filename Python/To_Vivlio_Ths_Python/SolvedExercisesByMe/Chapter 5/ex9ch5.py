"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

numbers = []
totalNumbers = 0
MO = 0
totalBiggerThanMax = totalSmallerOrEqualThanMax = 0

while True:
    tempNum = int(input("Dwse enan arithmo(arnhtiko gia stop): "))
    if tempNum < 0:
        break
    else:
        numbers.append(tempNum)
        totalNumbers += 1

print("Total numbers given: ", totalNumbers)
MO = sum(numbers) / totalNumbers
print("MO: ", MO)

for i in range(len(numbers)):
    if numbers[i] <= MO:
        totalSmallerOrEqualThanMax += 1
    else:
        totalBiggerThanMax += 1

print("Total numbers that are smaller than or equal to the average of all the numbers: ", totalSmallerOrEqualThanMax)
print("Total numbers that are bigger than average of all the numbers: ", totalBiggerThanMax)