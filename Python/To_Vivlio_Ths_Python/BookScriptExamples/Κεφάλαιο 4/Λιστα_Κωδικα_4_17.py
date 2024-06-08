# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-17. Υπολογισμός του “π” με προσομοίωση Monte Carlo 
import math
import time
import random
e=10**(-int(input('Ακρίβεια:')))
n=m=0
mypi=0
while abs(math.pi-mypi)>=e:
    x=random.random()
    y=random.random()
    n+=1
    if x**2+y**2<1:
        m+=1    
    mypi=4*m/n
#Εμφάνιση στην οθόνη με χρονοκαθυστέρηση        
    time.sleep(0.25)
    print('\b'*10,end='')
    print(round(mypi,8),end='')    
print(mypi)
print(math.pi)
