"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from math import floor

while True:
    N = int(input('Dwse arithmo anamesa sto [0...100]: '))
    if N < 0 or N > 100:
        print('Enter valid data')
    else:
        break

#check the amount of digits
tempN = N
dig = 0

while tempN != 0:
    tempN = tempN // 10
    dig += 1
else:
    if N == 0:
        dig += 1

print('Digits:', dig)

ctr = 2
while ctr < N:
    if N % ctr == 0:
        break
    else:
        ctr += 1

if 2 <= ctr < N:
    elem = 0
    factors = []
    tempN = N
    factors.insert(elem, ctr)
    tempN = tempN // ctr
    elem += 1
    
    while True:
        ctr = 2
        while ctr < tempN:
            if tempN % ctr == 0:
                break
            else:
                ctr += 1
	   
        if ctr == tempN:
            factors.insert(elem, ctr)
            break
        
        factors.insert(elem, ctr)
        tempN = tempN // ctr
        elem += 1
else:
    elem = 0
    factors = []
    factors.insert(elem, 1)
    elem += 1    
    factors.insert(elem, N)
       
factors.sort()
print(factors)
        


