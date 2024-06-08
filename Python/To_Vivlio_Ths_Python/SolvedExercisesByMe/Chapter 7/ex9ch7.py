"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

initialList = [1, 3, 5, 6, 7, 8, 9, 8, 0]

finalList = []

for item in initialList:
    tempTup = (item, item ** 2, item ** 0.5)
    finalList.append(tempTup)

print(finalList)