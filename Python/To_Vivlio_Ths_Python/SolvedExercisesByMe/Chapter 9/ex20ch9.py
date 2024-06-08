"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}
dict2 = {}

for i in range(10): #tuxaia kleidia kai tyxaies times alla ta 2 leksika exoun ta idia kleidia
    key = randint(0, 100)
    dict1[key] = randint(0, 100)
    dict2[key] = randint(0, 50)

#to neo leksiko tha exei ta idia kleidia kai times ta antistoixa athroismata ton timon twn 2 leksikon
dict3 = {}
for i in dict1.keys():
    dict3[i] = dict1[i] + dict2[i]

print(dict1, dict2, dict3, sep = '\n')