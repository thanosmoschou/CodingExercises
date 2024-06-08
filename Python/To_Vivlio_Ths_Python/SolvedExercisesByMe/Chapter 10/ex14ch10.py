"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def yposun(lis1, lis2):
    if len(lis1) <= len(lis2): #lis1 < lis2 ara vlepo an i mikroteri einai uposunolo ths megaliteris    
        sameCtr = 0 #den thelo na mplekso me boolean ara to kano me counter. An o counter ginei isos me to mikos ths mikroteris upolistas tote einai uposinolo
        for item1 in lis1:
            for item2 in lis2:
                if item1 == item2:
                    sameCtr += 1
                    break
        
        if sameCtr == len(lis1):
            return f'H lista {lis1} einai uposinolo tis listas {lis2}'
        else:
            return f'H lista {lis1} den einai uposinolo tis listas {lis2}'
    else:
        sameCtr = 0 #den thelo na mplekso me boolean ara to kano me counter. An o counter ginei isos me to mikos ths mikroteris upolistas tote einai uposinolo
        for item1 in lis2:
            for item2 in lis1:
                if item1 == item2:
                    sameCtr += 1
                    break #gia na min uparxoun perissoteres idies times stin megaliteri upolista kai ginei lathos upologismos. Thelo 1 fora na auksiso
        
        if sameCtr == len(lis2):
            return f'H lista {lis2} einai uposinolo tis listas {lis1}'
        else:
            return f'H lista {lis2} den einai uposinolo tis listas {lis1}'


len1, len2 = randint(1, 20), randint(1, 20)
list1, list2 = [randint(0, 5) for x in range(len1)], [randint(0, 10) for x in range(len2)]
print(f'Lista 1 = {list1}\nLista 2 = {list2}\nElegxos gia yposinolo = {yposun(list1, list2)}')