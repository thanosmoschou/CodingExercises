"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

dict1 = {} #or dict1 = dict()

for key in range(10, 15):
    dict1[key] = key ** 2

keyForRemove = int(input("Please enter a number: "))

if dict1.get(keyForRemove, 0) != 0: #an h get epistrepsei 0 tote to kleidi den uparxei. An epistrepsei alli timi tote tha
    val = dict1.pop(keyForRemove)   #diagrapso to zeugari kleidi:timi afou soso thn timi pou antistoixei sto sugkekrimeno kleidi oste na eisago to neo kleidi mias kai to kleidi einai
    newKey = int(input("Please enter the new key: "))   #immutable kai den mporei na metavlithei
    if dict1.get(newKey, 0) != 0: #to neo kleidi an uparxei stamatao. An oxi tote proxorao se eisagogi
        print("Key already exists...")
    else:
        dict1[newKey] = val   
else:
    print("Key does not exist...")             

print(dict1)