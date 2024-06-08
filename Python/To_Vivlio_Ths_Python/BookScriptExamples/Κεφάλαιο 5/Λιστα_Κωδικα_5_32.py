# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 5-32. Αναζήτηση σε λίστα 
num=[2,5,3,7,5,8,2,4,6,4,2]
pos=[]
key=int(input("Δώσε έναν αριθμό:"))
for i,item in enumerate(num):
    if item==key:
        pos.append(i)
print(pos)
