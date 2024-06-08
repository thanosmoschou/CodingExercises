"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

value = input("Please enter a message: ")
value2 = list('geia') #mporo os orisma stin list na exo () h string anti gia []. Genika 1 orisma epanaliptiko antikeimeno. Mporo kai range 

set1 = set()
set2 = set()

for char in value:
    set1.add(char)

for item in value2:
    set2.add(item)

print(set1, set2, sep = '\n')