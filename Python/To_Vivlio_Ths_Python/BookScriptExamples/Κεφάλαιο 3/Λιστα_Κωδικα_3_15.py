# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 3-15. if μιας γραμμής – υπολογισμός έκπτωσης 
sales=float(input('Δώσε το ποσο αγορας:')) 
if sales>=200:
    sales-=sales*20/100
else:
    sales-=sales*10/100
print('Τελικό ποσό:',sales,'€')
#ή με if μιας γραμμής
sales-=sales*20/100 if sales>=200 else sales*10/100
print('Τελικό ποσό:',sales,'€')
