# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 7-9. Χρήση ενός namedtuple 
import collections
employee=collections.namedtuple('Employee','name age sal dept')
anna=employee(name='Αννα',sal=950,age=26,dept='ΙΤ')
peter=employee(name='Πετρος',sal=1100,age=28,dept='ΙΤ')
george=employee(name='Γιωργος',sal=900,age=30,dept='Sales')
emps=[anna,peter,george]
for emp in emps:
    print(f'Ονομα:{emp.name}, Μισθός:{emp.sal}')
