# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-26. 5 βαθμοί me flag 
ep=True
for i in range(5):
    g=float(input('Δώσε ένα βαθμό:'))
    if g<5:
        ep=False
        break
if ep:
    print('Επιτυχία')
else:
    print('Επανάληψη')        
