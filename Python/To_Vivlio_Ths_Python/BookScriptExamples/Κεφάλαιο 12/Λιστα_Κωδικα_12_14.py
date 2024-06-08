# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-14. Πολλαπλή λειτουργία 
f=open('invoices.txt','r+')
invoices=list(map(float,f.readlines()))
for invoice in invoices:
    f.write(str(invoice*0.24)+'\n')
f.close()
f=open('invoices.txt','r')
print(f.readlines())
f.close()
