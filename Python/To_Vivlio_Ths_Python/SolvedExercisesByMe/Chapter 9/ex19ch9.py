"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}

for i in range(10): #tuxaia kleidia kai times listes me tyxaies times mesa tous
    dict1[randint(0, 100)] = [randint(0, 100) for x in range(10)] 

print(dict1)

dict2 = {key:len(dict1[key]) for key in dict1.keys()} #epistrefo kleidi kai timi kai tha valo sto neo leksiko to mikos tis listas os timi me kleidi to hdi uparxon
print(dict2)