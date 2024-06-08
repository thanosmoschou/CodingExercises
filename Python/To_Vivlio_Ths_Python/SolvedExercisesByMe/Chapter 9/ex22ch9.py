"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}
for i in range(10):
    dict1[randint(1000, 9999)] = randint(9999, 100000)

print(dict1)
info = input("Dwse username(me arithmous) kai password(pali me arithmous) me tin eksis morfi(username password): ")
listOfCred = info.split()
listOfCred[0], listOfCred[1] = int(listOfCred[0]), int(listOfCred[1])

#Thelo na vro an uparxei to kleidi sto dictionary kai an uparxei tote elegxo an o kwdikos einai sostos
if dict1.get(listOfCred[0], 0) != 0 and dict1[listOfCred[0]] == listOfCred[1]:
    print("Egkura stoixeia.")
else:
    print("Mi egkura stoixeia.")