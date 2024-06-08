"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from pexpect import EOF


s1 = set()
s2 = set()

while True:
    value = eval(input("Please enter a value(Insert ' ' to stop): "))
    if value != ' ':
        s1.add(value)
        s2 = s1.copy()
    else:
        break

print(s1)
print(s2)