# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-25. 5 βαθμοί με counter 
counter=0
for i in range(5):
    g=float(input('Δώσε ένα βαθμό:'))
    if g>=5:
        counter+=1
if counter==5:
    print('Επιτυχία')
else:
    print('Επανάληψη')        
