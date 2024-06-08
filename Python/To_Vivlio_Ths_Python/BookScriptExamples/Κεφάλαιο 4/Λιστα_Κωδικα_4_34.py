# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-34. secret number 

import time
secret='1234'
p=0
answer=input('Δώσε το συνθηματικό:')
while answer!=secret:
    p+=1
    print('Λάθος συνθηματικό. Προσπάθησε ξανά')
    print('Έχεις ακόμη',3-p,'προσπάθειες')
    if p==3:
        print('Η επόμενη προσπάθειά σου ξεκινάει σε...')
        for i in range(30,-1,-1):
            time.sleep(1)
            print('\b'*2,end='')
            print(i,end='')
        p=0

    answer=input('Δώσε το συνθηματικό:')        
