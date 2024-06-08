# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-41. Ανώνυμες συναρτήσεις 
l=[-1,3,6,-4,25,1,-2,144]
f=lambda x:x**2
#ζητούμενο 1
x=[f(i) for i in l]
print(x)
#ζητούμενο 2
y=list(filter(lambda x:x>0,l))
print(y)
# ζητούμενο 3
z=list(filter(lambda x:x%2==0 and x>0,l))
print(z)
# ζητούμενο 4
print(*map(math.sqrt,filter(lambda x:x>0,l)))
