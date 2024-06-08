# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-19. «Βαθύ» αντίγραφο 
from copy import deepcopy 
student=dict(Ονομα='Γιώργος',ΓΠ=['C','Java'])
s2=deepcopy(student)
student['ΓΠ'].append('Python')
print(student)
print(s2)
