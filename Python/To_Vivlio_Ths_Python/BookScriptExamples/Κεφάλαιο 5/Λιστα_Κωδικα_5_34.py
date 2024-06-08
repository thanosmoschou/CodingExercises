# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 5-34. Εύρεση μέγιστου/ελάχιστου 
k=[9,22,5,3,7,2,11]
mymax=k[0]
mymin=k[0]
for i in range(1,len(k)):
    if k[i]>mymax:
        mymax=k[i]
    if k[i]<mymin:
        mymin=k[i]
print('Ο μέγιστος είναι:',mymax)
print('Ο ελάχιστος είναι:',mymin)
