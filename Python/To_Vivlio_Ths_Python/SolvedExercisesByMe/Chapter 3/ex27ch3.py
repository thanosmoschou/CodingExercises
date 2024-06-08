"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

num1 = eval(input("Please enter the 1st number: "))
num2 = eval(input("Please enter the 2nd number: "))


if num1 > 0 and num2 > 0:
    if num1 < num2:
        print(num1, "is closer to 0")
    elif num1 > num2:
        print(num2, "is closer to 0")
    else:
        print("Numbers have equal distance to 0")
elif num1 < 0 and num2 < 0:
    if num1 > num2:
        print(num1, "is closer to 0")
    elif num1 < num2:
        print(num2, "is closer to 0")
    else:
        print("Numbers have equal distance to 0")
elif num1 > 0 and num2 < 0:
    tempNum = -num2
    if num1 < tempNum:
        print(num1, "is closer to 0")
    elif num1 > tempNum:
        print(num2, "is closer to 0")
    else:
        print("Numbers have equal distance to 0")
elif num1 < 0 and num2 > 0:
    tempNum = -num1
    if num2 < tempNum:
        print(num2, "is closer to 0")
    elif num2 > tempNum:
        print(num1, "is closer to 0")
    else:
        print("Numbers have equal distance to 0")
elif num1 == 0 or num2 == 0:
    print("A number from those 2 is 0")