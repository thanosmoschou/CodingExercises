# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-51. Εύρεση μεγίστου με αναδρομή 
l=[2,4,1,6,3,5]

def maxx(l):
    if len(l)==1:
        return l[0]
    else:
        tempmax=maxx(l[1:])
        return tempmax if tempmax>l[0] else l[0]

print(maxx(l))
