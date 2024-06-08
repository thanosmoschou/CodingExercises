# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-18. Ανάγνωση αρχείου csv σε λεξικό 
import csv
f=open('csv.txt')
rdr=csv.DictReader(f,delimiter=',')
for record in rdr:
    print(dict(record))
f.close()
