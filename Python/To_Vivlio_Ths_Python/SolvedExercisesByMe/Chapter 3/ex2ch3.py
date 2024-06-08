"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

num = eval(input('Please insert a number: '))

if num > 0:
    print('Thetikos')
elif num < 0:
    print('Arnhtikos')
else:
    print('Miden')

if type(num) == int:
    print('Akeraios')
else:
    print('Pragmatikos')