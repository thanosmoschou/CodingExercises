# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-29. Παράμετροι με αστερίσκο – ζάρια 
import random
def randomsum(*z):
    return sum((random.randint(1,x) for x in z))

print(randomsum(4))
print(randomsum(4,2))
print(randomsum(4,5,6,2,1,5,2))
