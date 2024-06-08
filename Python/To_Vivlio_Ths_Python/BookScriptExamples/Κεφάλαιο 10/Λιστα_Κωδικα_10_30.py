# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-30. Παράμετροι με αστερίσκο – μέσος όρος 
def mo(*numbers):
    s=0
    for num in numbers:
        s+=num
    return s/len(numbers)

print(mo(1,2,3,4))
print(mo(1,2,3,4,5,9,23))
