# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-40. Συναρτήσεις – παράμετροι & ορίσματα 
from math import *
def calc(f,x):
    if f.__name__ in ['sqrt','log10'] and x<0:
        return 'Δεν ορίζεται'
    return f(x)
    
f=eval(input('Δώσε την συνάρτηση που θες:'))
num=int(input('Δώσε έναν αριθμό:'))
print(calc(f,num))
