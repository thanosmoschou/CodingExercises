"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint


def reverseNum(num1, num2):
    return (num2, num1) if num1 != num2 else "Numbers are not different" #more than 1 values return as a tuple with values


num1, num2 = [randint(0, 10) for x in range(2)] #unpacking my list
print(f'Number 1: {num1}', f'Number 2: {num2}', f'Reversed numbers result: {reverseNum(num1, num2)}', sep = '\n')