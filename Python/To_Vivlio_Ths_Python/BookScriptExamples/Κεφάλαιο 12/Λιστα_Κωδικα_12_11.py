# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-11. Μια εφαρμογή κουίζ 
f=open("quiz.txt")
lines=f.readlines()
hits=missed=0
for line in lines:
    if not line.strip('\n').isnumeric():
        print(line,end='')
    else:
        ans=input('Δώσε την απάντησή σου:')
        if ans==line.strip('\n'):
            hits+=1
            print('Μπράβο, το βρήκες!!!')
        else:
            missed+=1
            print('Δεν πειράζει, την επόμενη φορά...')
        input('Πάτησε <Enter> για να συνεχίσεις...')
print(f'Πέτυχες {hits} σωστές απαντήσεις')
print(f'Έχασες {missed}  απαντήσεις')
print(f'{hits/(hits+missed)*100:.4}% ποσοστό επιτυχίας')
f.close()
