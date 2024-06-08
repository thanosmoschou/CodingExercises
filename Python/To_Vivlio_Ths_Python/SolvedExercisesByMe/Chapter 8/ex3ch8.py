"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import random

s1 = set()
while True:
    s1.add(random.randint(0, 10))
    if len(s1) == 10:
        break
print(s1)