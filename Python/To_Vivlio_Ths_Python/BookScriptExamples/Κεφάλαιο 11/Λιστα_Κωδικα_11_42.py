# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-42. Πολλαπλή κληρονομικότητα 
class A:
     pass
class B:
    pass
class C(B,A):
    pass

b=B()
c=C()
print(isinstance(c,C))
print(isinstance(c,A))
print(isinstance(c,C))
print(isinstance(b,A))
print(issubclass(C,A))
print(issubclass(C,B))
print(issubclass(B,A))
