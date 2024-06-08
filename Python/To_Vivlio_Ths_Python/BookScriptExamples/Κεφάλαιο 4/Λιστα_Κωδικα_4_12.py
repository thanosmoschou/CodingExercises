# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-12. Πέτρα-ψαλίδι-χαρτί 
import random
rounds=int(input('Δώσε το πλήθος των παιχνιδιών:'))
pwin=0
cwin=0
choices=['Πέτρα','Ψαλίδι','Χαρτί']
for i in range(rounds):
    print('Παιχνίδι',i+1,'ο')
    player=int(input('Πέτρα(0),Ψαλίδι(1) ή Χαρτί(2);'))
    pc=random.randint(0,2)
    print('Ο αντίπαλος είχε:',choices[pc])
    if player==pc:
        print('Ισοπαλία')
    elif (player==0 and pc==1)\
        or (player==1 and pc==2)\
        or (player==2 and pc==0):
        pwin+=1
        print('Κέρδισες')
    else:
        cwin+=1
        print('Έχασες')
print('Κέρδισες',pwin,'παιχνίδια...',end='')
if pwin==cwin:
    print('και ήρθατε ισοπαλία.')
elif pwin>cwin:
    print('και είσαι ο νικητής!')
else:
    print('αλλά έχασες.')
