"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

#tha to kano pali me arithmous kai oxi me thlefona
s1 = set()
s2 = set()

s1.update([randint(0, 100) for x in range(10)])
s2.update([randint(0, 30) for x in range(20)])

print(f's1: {s1}', f's2: {s2}', f'Numbers that are shown in both sets: {s1 & s2}', sep = '\n')