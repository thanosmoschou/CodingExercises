# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 3-10. Σύνθετη if – το παιχνίδι κορόνα-γράμματα 
from random import randint
coin=randint(0,1)
user=int(input('Δώσε 0 (κορόνα) ή 1(γράμματα):'))
if user==coin:
    print('Κέρδισες!')
else:
    print('Έχασες')
