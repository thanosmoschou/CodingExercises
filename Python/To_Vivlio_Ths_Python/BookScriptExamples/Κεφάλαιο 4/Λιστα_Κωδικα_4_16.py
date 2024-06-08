# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-16. while – ανελκυστήρας 
persons=total=0
weight=float(input('Βάρος:'))
while total+weight<=650 and persons<7:
    total+=weight
    persons+=1
    weight=float(input('Βάρος:'))
print('Ατομα:',persons,'Συνολικό βάρος:',total)
