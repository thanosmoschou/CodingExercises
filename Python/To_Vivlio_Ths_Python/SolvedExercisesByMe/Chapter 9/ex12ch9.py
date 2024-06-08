"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#num = int(input("Please enter a 3-digit number: "))
while True:
    num = input("Please enter your 3-digit number here:") #validity check
    if len(num) == 3 and num.isdigit(): #isdigit() gia na min dinei sumvola
        break
    else:
        print("Please enter only numbers that are 3 digits long...")

dict1 = dict()
dict1 = dict1.fromkeys(['Ekatontades', 'Dekades', 'Monades'], 0) #se ola ta kleidia arxiki timi 0

# ekat = num // 100
# rem = num % 100
# dek = rem // 10
# mon = rem % 10

# dict1['Ekatontades'] = ekat
# dict1['Dekades'] = dek
# dict1['Monades'] = mon
#anti na spaso ton arithmo, afou i morfi eisagogis einai string kai to string mporo na to xeiristo san lista 
#xrhsimopoio deiktodotisi gia kathe char kai to metatrepo se int
dict1['Ekatontades'] = int(num[0])
dict1['Dekades'] = int(num[1])
dict1['Monades'] = int(num[2])

print(dict1)