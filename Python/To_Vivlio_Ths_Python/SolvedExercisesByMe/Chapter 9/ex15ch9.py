"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

dict1 = {'0': '17/9', '1': '18/9', '2': '20/9', '3': '21/9', '4': '22/9', '5': '23/9', 
'6': '24/9', '7': '25/9', '8': '26/9', '9': '27/9'}

while True:
    afm = input("Dwse to afm sou: ")
    #pairno to teleutaio psifio tou string kai to kano kleidi sto leksiko mou
    print(f'H teliki hmerominia katavolis ths forologikhs sou einai: {dict1[afm[len(afm) - 1]]}')
    
    while True:
        decision = input("Thes na sumexiseis(Y/N)? ")
        if decision.upper() != 'Y' and decision.upper() != 'N':
            print("Parakalw eisagete egkura dedomena...")
        else:
            break
    
    if decision.upper() == 'N':
        break