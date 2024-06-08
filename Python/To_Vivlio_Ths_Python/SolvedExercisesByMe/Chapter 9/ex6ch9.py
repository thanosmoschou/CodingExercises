"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

dict1 = dict()
dict2 = dict()
dict3 = dict()

for i in range(5):
    dict1[i] = i ** 2
    dict2[i + 5] = (i + 2) ** 2
    dict3[i + 10] = (i + 4) ** 2

print(dict1, dict2, dict3, sep = '\n')
dict3.update(dict1)
dict3.update(dict2)
print(dict3)