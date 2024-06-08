# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 3-24. try – καταγραφή μηνύματος 1 
try:
    x=float(input('Δώσε έναν αριθμό:'))
    y=1/x
    print(y)
except (ValueError,ZeroDivisionError) as e:
    print('Εμφανίστηκε το σφάλμα:',e)
print('Τέλος προγράμματος')    
