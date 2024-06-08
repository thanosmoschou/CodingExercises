# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 5-25. Χρήση του not in 
passwords=['qwerty','123','Ανοιξε σουσάμι']
while True:
    phrase=input('Δώσε το συνθηματικό:')
    if phrase not in passwords:
        print('Λάθος...Ξαναδοκίμασε')
    else:
        print('Μπορείς να προχωρήσεις')
        break
print('Καλώς όρισες')        
