# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-22. Το παιχνίδι με τα ζάρια 
import random
input('Πάτα <ENTER> για να ρίξεις τα ζάρια')
d1=random.randint(1,6)
d2=random.randint(1,6)
s=d1+d2
print('Εφερες',d1,'και',d2,'Αθροισμα:',s)
if s==7 or s==11:
    print('Κέρδισες')
elif s==2 or s==3 or s==12:
    print('Εχασες')
else:
    print('Ξαναπαίζεις')
    while True:
        input('Πάτα <ENTER> για να ρίξεις τα ζάρια')
        d1=random.randint(1,6)
        d2=random.randint(1,6)
        s=d1+d2
        print('Εφερες',d1,'και',d2,'Αθροισμα:',s)
        if s>7:
            print('Ξαναπαίζεις')
            continue
        if s<7:
            print('Κέρδισες (<7)')
        elif s==7:
            print('Εχασες (=7)')
        break        
