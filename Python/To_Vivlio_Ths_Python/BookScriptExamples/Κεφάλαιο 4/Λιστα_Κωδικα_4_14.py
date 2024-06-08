# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-14. while – αποταμίευση 
weeks=total=0
while total<450:
    amount=float(input('Δώσε το ποσό:'))
    total+=amount 
    weeks+=1
print('Χρειάστηκε να περάσουν',weeks,'εβδομάδες')
print('Περισεψαν',total-450,'€')
