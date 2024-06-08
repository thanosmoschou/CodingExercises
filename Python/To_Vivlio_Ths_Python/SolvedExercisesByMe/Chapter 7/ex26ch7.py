"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import collections

list = [1, 4, 6, 7, 0, 10]
arithmos = collections.namedtuple('Arithmos', 'Arithmos Antistrofos Antithetos')
tup = ()

for item in list:
    num = arithmos(Arithmos = item, Antistrofos = 1 / item if item != 0 else 'D/Y', Antithetos = -item)
    tup += num,

print(tup)