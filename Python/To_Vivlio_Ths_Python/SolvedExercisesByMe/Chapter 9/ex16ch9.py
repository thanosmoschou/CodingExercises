"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}

for i in range(10): #tuxaia kleidia kai tyxaies times
    dict1[randint(0, 100)] = randint(0, 100)

print(dict1)
list3 = [(key + value) for key, value in dict1.items()]
print(list3)