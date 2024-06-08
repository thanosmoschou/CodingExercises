"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

hours = int(input('Please enter the total hours that you had been parked: '))

sum = 0
if hours > 2:
    sum += 5 + (hours - 2) * 1.5
else:
    sum += 5

print('The total price is: ', sum) 