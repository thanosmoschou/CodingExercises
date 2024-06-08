# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-7. Ανάγνωση αρχείου με τη readline 
f=open("sales.txt")
line=f.readline()
i=0
while line:
   line=f.readline()
   i+=1
   print(line,end='')    
print(f'Το αρχείο περιέχει {i} πωλήσεις.')
f.close()
