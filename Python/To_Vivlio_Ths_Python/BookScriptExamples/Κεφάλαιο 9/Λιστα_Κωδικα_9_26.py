# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-26. Πολλαπλή επεξεργασία – setdefault 
d=dict(a=10,b=20)  
d 
d.setdefault('a')
d.setdefault('b',15)
d.setdefault('c')
d['c']
d
d.setdefault('d',15)
x=d.setdefault('e',30)
x
d
