"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import cmath
import math

dict1 = dict()
dict1 = dict.fromkeys(['log', 'pow', 'sin', 'cos', 'tan'])

while True:
    num = int(input("Please enter a number: "))
    dict1['log'] = cmath.log(num)
    dict1['pow'] = pow(num, num)
    dict1['sin'] = cmath.sin(num)
    dict1['cos'] = cmath.cos(num)
    dict1['tan'] = cmath.tan(num)
    print(dict1)

    while True:
        decision = input("Do you want to continue(Y/N)? ")

        if decision.upper() != 'Y' and decision.upper() != 'N':
            print("Please enter valid data...")
        else:
            break
    
    if decision.upper() == 'N':
        break