# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-12. Εγγραφή αρχείου με τη write 
file=open('wsales.txt','w')
file.write('Ημερήσιες Πωλήσεις\n')
for i in range(5):
    sales=input(f'Δώσε τις πωλήσεις της {i+1}ης ημέρας:')
    file.write(sales+'\n')
file.close()
