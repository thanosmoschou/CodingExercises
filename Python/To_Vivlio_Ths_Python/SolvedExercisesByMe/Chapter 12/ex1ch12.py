"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

try:
    name = 'ex1ch12.dat' #an to valo kato apo to anoigma se periptosi pou apotuxei to anoigma den tha ektelestei o kodikas apo kato kai sto except tha exo provlima
    filename = open('ex1ch12.dat', 'r')
except FileNotFoundError:
    print(f'Problem with file: {name}')
else: #ekteleitai mono an doulepsei o kodikas sto try. An ithela na treksei o parakato kodikas etsi kai allios tha evaza finally 
    data = filename.readline() #diavazo kathe grammi kai stin spao se lista. Tora tha paro tin kathe grammi
    wordCtr = 0

    while data: #an diavasei EOF isodinamei me 0 ara false
        words = []
        words = data.split()
        for item in words:
            if item != '.' and item != ',':
                wordCtr += 1
        data = filename.readline()

    filename.close()
    print(f'Words in file {name}: {wordCtr}')