# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 3-25. try – καταγραφή μηνύματος 2 
try:
    z=math.sqrt(x)
    y=x/z
    print(y)
except (ValueError,ZeroDivisionError) as e:
    print('Εμφανίστηκε το σφάλμα:',e)
print('...το πρόγραμμα συνεχίζεται...')    
