# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-20. Διαχειριστής περιεχομένου 
with open('calls.txt') as file:
    for call in file:
        if 'out' in call:
            print(call,end='')
