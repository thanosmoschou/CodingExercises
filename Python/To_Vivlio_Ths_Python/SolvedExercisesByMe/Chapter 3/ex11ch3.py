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
        print("Min: ", numA, "Max: ", numC)
    else:
        print("Min: ", numA, "Max: ", numB)
elif numB < numC:
    if numA < numC:
        print("Min: ", numB, "Max: ", numC)
    else:
        print("Min: ", numB, "Max: ", numA)
else:
    if numA < numB:
        print("Min: ", numC, "Max: ", numB)
    else:
        print("Min: ", numC, "Max: ", numA)

    