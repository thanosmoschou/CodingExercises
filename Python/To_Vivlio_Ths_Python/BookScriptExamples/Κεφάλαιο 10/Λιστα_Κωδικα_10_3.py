# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-3. Εμφανίζοντας ημερομηνία & ώρα 
def now():
    import time
    s=time.strftime("%a, %d %b %Y %H:%M:%S",time.gmtime())
    print(s)
    time.sleep(0.3)

now()
now()
