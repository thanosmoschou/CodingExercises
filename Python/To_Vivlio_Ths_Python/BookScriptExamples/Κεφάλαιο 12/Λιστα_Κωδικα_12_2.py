# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-2. Διαχείριση εξαιρέσεων κατά το άνοιγμα αρχείου 
try:
    f=open("sales.txt")
except FileNotFoundError:
    print("Υπάρχει πρόβλημα με το αρχείο!")
else:
    lines=f.read()
    print(lines)
    f.close()
