"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = ((2, 4), 3, (5, 6, 8), 'F')

print(tup)
itemForDeletion = eval(input("Please enter the object that you want to delete from the tupple: "))
found = False

for item in tup:
    if item == itemForDeletion:
        found = True
        break

if found:
    newTup = ()
    for item in tup:
        if item != itemForDeletion:
            newTup += item,

    tup = newTup
    print(tup)
else:
    print(f"Item: {itemForDeletion} not found.")