# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-58. Διακόσμηση – n-στή ρίζα 
def calc(f):
    def root(x,n):
        if x<0 or n==0:
            return f'η {n}η ρίζα του {x} δεν ορίζεται'
        return f'η {n}η ρίζα του {x} είναι:{f(x,n)}'
    return root

@calc
def nthroot(x,n):
    return x**(1/n)

print(nthroot(x=125,n=3))
