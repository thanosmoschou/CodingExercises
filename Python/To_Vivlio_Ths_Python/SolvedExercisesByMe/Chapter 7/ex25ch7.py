"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import collections

orthogonio = collections.namedtuple('Orthogonio', 'Mikos Platos Emvado Perimetros')
listOfTupples = []

while True:
    dimensions = input("Dwse to mhkos kai to platos orthogoniou me morfi(mikos platos): ") #string format for the dimensions
    dimensions = dimensions.split() #split the message into this list and convert the dimensions to int format
    dimensions = [int(dimensions[i]) for i in range(len(dimensions))] #list comprehension and convertion to int
    
    dimensions = orthogonio(Mikos = dimensions[0], Platos = dimensions[1], Emvado = dimensions[0] * dimensions[1],
    Perimetros = 2 * dimensions[0] + 2 * dimensions[1])
    
    print(dimensions)
    listOfTupples.append(dimensions)

    while True: #Continue question with validity check
        decision = input("Continue(Y/N)? ")
        if decision.upper() != 'N' and decision.upper() != 'Y':
            print("Please give valid data(Y/N)...")
        else:
            break
    
    if decision.upper() == 'N':
        break

print(listOfTupples)