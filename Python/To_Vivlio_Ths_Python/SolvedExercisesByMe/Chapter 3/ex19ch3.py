"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

num = int(input("Please enter 3-digit number: "))


checkArm = ((num % 10) ** 3 + ((num % 100) // 10) ** 3 + (num // 100) ** 3)

if num == checkArm:
    print(num, "is an Armstrong number")
else:
    print(num, "is not an Armstrong number")


