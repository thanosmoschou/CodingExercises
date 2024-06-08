# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-43. Πολυεπίπεδη κληρονομικότητα 
class A:
     pass
class B(Α):
    pass
class C(B):
    pass
c=C()
print(isinstance(c,A))
print(issubclass(C,A))
print(issubclass(C,B))
