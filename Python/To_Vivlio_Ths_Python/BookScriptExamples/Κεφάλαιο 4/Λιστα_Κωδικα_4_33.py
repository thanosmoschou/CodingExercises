# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-33. Pin και puk 
pin='1234'
puk='123456789'
tr=0
while True:
    tr+=1
    p=input(f'Δώσε pin (έχεις {4-tr} προσπάθειες):')
    if p==pin:
        break
    if tr!=3:
        continue
    print('Το pin κλείδωσε.')
    tr=0
    while True:
        tr+=1
        p=input(f'Δώσε puk (έχεις {11-tr} προσπάθειες):')
        if p==puk:
            break
        if tr!=10:
            continue
        print('Το τηλέφωνο κλείδωσε.')
        while True:# Θα κλειδώσει εδώ το πρόγραμμα
            pass
    break
print('Καλώς όρισες')        
