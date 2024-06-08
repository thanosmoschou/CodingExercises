"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

f0 = f = 0
f1 = 1

lim = int(input("Dwse ena orio gia thn akolouthia Fibonacci: "))
print(f0)
print(f1)
f = f0 + f1

while f <= lim:
    print(f)
    f0 = f1
    f1 = f
    f = f0 + f1
