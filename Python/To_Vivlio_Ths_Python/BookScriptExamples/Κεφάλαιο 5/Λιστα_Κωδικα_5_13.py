# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 5-13. Η λειτουργία append 
grades=[2,10,9,4,1,6,6,1,0]
k=[]
for item in grades:
    if item<5:
        k.append(item)
print(k)
