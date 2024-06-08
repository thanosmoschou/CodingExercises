"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

numA = eval(input("Give the 1st number: "))
numB = eval(input("Give the 2nd number: "))
numC = eval(input("Give the 3rd number: "))


if numA < numB and numA < numC:
    if numB < numC:
        print(numA, numB, numC)
    else:
        print(numA, numC, numB)
elif numB < numC:
    if numA < numC:
        print(numB, numA, numC)
    else:
        print(numB, numC, numA)
else:
    if numA < numB:
        print(numC, numA, numB)
    else:
        print(numC, numB, numA)

    