"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def oppositeAndReversed(num):
    if num != 0:
        return -num, 1/num
    else:
        return num, 'This number cannot be reversed'
    
num = randint(0, 10)
print(num, "Opposite = {0} Reversed = {1}".format(*oppositeAndReversed(num)), sep = '\n') #unpack the tuple