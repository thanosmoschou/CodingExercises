"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

print('Dwse tous suntelestes ths 2-vathmias eksisosis ax**2 + bx + c = 0 : ')
a = int(input('Dwse to a: '))
b = int(input('Dwse to b: '))
c = int(input('Dwse to c: '))


if a == 0:
    if b == 0:
        if c == 0:
            print('Aoristi...')
        else:
            print('Adinati...')
    else:
        r = -c / b
        print('r: ', r)
else:
    D = b**2 - 4*a*c
    if D > 0:
        r1 = (-b + D**(1/2)) / 2*a
        r2 = (-b - D**(1/2)) / 2*a
        print('r1: ', r1, 'r2: ', r2)
    elif D == 0:
        r = -b / 2*a
        print('r: ', r)
    else:
        print('Adinati...')
        