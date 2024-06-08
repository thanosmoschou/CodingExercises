# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-6. Ανάγνωση αρχείου μέσω της for 
f=open("sales.txt")
line=f.readline()
i=0
for line in f:
    print(line,end='')
    i+=1
print(f'Το αρχείο περιέχει {i} πωλήσεις.')
f.close()
