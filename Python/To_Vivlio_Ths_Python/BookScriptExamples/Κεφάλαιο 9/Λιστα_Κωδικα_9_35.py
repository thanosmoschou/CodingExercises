# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-35. Ταξινόμηση σε for me lambda 
sales=dict(Γιώργος=5000,Πέτρος=8000,Νίκη=7500) 
for name,amount in sorted(sales.items(),key=lambda x:x[1], reverse=True):
    print(name, end=',')
