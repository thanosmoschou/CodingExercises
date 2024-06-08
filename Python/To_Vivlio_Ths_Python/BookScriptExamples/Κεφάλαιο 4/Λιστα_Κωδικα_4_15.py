# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-15. while – δωροεπιταγή 
total=num=0
price=float(input('Δώσε την τιμή:'))
while price+total<=500:
    total+=price
    num+=1
    price=float(input('Δώσε την τιμή:'))
if total!=500:
    print('Περίσσεψαν',500-total,'€')
else:
    print('Δεν έμεινε τίποτα')
print('Αγόρασες',num,'προϊόντα')
