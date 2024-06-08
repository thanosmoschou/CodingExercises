"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

dict1 = {2: 3, 4: 5, 8: 9, 0: None}

found = False
for i in dict1.keys():
    if dict1[i] == None:
        found = True
        break

if found:
    print(f"Yparxoun times {None}")
else:
    print(f"Den uparxoun times {None}")