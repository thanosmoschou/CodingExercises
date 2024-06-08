# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-23. Χρήση παραμέτρων – διαχωρισμός 
def divide(numbers):
    pos,nez=[],[]
    for number in numbers:
        if number>0:
            pos.append(number)
        else:
            nez.append(number)
    return pos,nez

somelist=[-1,3,5,2,6,4,7,-5,-3,4]
list1,list2=divide(somelist)
print('Θετικά στοιχεία:',list1)    
print('Αρνητικά στοιχεία:',list2)    
