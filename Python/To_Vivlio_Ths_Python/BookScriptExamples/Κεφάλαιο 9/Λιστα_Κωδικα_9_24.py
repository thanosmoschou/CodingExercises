# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-24. Ενημέρωση λεξικού – πλήθος φωνηέντων 
phrase=input('Δώσε μια φράση:')  
for char in phrase: 
    if char in f:
        v[char]+=1
#ή      v[char]=v.get(char)+1
print(v)
