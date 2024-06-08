"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

numb = input("Please enter a number(3-digits in total): ")

dictNum = numb.maketrans({'1': 'Ena', '2': 'Dio', '3': 'Tria', '4': 'Tessera', '5': 'Pente', '6': 'Eksi', '7': 'Efta', '8': 'Okto', 
'9': 'Ennia', '0': 'Miden'})

numb = numb.translate(dictNum) #antikathisto tous arithmous me vasi to leksiko mou. Tora tha xoriso tis lekseis.
newNumb = numb[0] #vazo apo edo to 1o gramma tou string pou einai sigoura kefalaio kai den to vazo sth for gia na mhn exo space sthn arxi
for ctr in range(1, len(numb)):
    if numb[ctr].isupper(): #gia na min einai kollita oi lekseis kathe fora pou vlepo kefalaio ektos apo to 1o kefalaio tha vazo ena keno
        newNumb = newNumb + ' ' + numb[ctr]
    else:
        newNumb = newNumb + numb[ctr]
print(newNumb)