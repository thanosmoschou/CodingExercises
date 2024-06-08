# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-32. Πρώτοι αριθμοί 
n=int(input('Δώσε έναν ακέραιο:'))
for i in range(2,n+1):
    j=2
    while j<i:      
        if not i%j:
            break
        j+=1
    else:
        print(i,end=' ')        
