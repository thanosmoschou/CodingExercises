# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-9. Χρήση ονομάτων 
def findmax():
    if a>b:
        max='Max='+str(a)
    else:
        max='Max='+str(b)
    print(max)
a=1
b=0
findmax()
print(max(a,b))
