# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-17. Ανάγνωση αρχείου csv σε λίστα 
import csv
f=open('csv.txt')
rdr=csv.reader(f,delimiter=',')
for record in rdr:
    print(record)
f.close()
