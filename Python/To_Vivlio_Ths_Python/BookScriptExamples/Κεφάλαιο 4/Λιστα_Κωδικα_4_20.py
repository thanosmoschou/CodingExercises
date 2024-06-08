# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-20. Μάντεψε τον αριθμό 
import random
secret=random.randint(1,100)
tries=0
while True:
    tries+=1
    number=int(input('Δώσε εναν αριθμο (1-100):'))
    if number==secret:
        break
    elif number>secret:
        print('Πήγες πολύ ψηλά. Κατέβα λίγο')
    else:
        print('Κατέβηκες χαμηλά. Ανέβα λίγο')
print('Τα κατάφερες σε μόλις {0} προσπάθειες'.format(tries))        
