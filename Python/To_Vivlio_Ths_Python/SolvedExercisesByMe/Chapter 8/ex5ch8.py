"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import random

#random values for this set
s1 = set()
list1 = [0]*10
ctr = 1
while True:
    value = random.randint(1, 10)
    ctr += 1
    if ctr == 100:
        break
    s1.add(value) #add the value if not exists in the set
    list1[value - 1] += 1 #update the showing rate of the value. Always go 1 position back. List starts from 0 and numbers from 1 so position 0 store 1, 1 store 2 etc.

s2 = set()
for item in s1:
    s2.add((item, list1[item - 1])) #for every single value also insert the showing rate with tupple format
                                    #check line 13 in order to understand why i subtract 1 everytime
print(s2)                           