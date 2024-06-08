"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import os

with open('ex9ch12.dat', 'r') as file:
    path = file.read()
    path = path[: -1] #vgazo to \n
    print(os.listdir(path))