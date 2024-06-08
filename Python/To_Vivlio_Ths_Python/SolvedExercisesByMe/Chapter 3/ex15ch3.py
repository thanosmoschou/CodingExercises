"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

sideA = eval(input("Give the 1st side of the triangle: "))
sideB = eval(input("Give the 2nd side of the triangle: "))
sideC = eval(input("Give the 3rd side of the triangle: "))

if sideA == sideB and sideA == sideC and sideB == sideC:
    print("Isopleuro")
elif (sideA == sideB and sideC != sideA) or (sideA == sideC and sideB != sideC) or (sideB == sideC and sideA != sideB):
    print("Isoskeles")
else:
    print("Skalino")