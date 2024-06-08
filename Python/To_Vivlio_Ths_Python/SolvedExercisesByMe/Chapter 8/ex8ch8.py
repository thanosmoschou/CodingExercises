"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import random

#tha to kano me arithmous anti gia titlous. Einai akrivos idia logiki
s1 = set()
s2 = set()

s1.update([random.randint(0, 100) for x in range(10)])
s2.update([random.randint(0, 30) for x in range(20)])

print(f's1: {s1}', f's2: {s2}' ,f'Common numbers of s1 and s2: {s1 & s2}', f'Numbers of s1 that are not in s2: {s1 - s2}', 
f'Numbers that are unique: {s1 ^ s2}', sep = '\n')