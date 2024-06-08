# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-15. Δυαδικά αρχεία 
f=open("binfile.bin","wb")
numbers=[5, 150, 20, 250]
array=bytearray(numbers)
print(array)
f.write(array)
f.close()
f=open("binfile.bin","rb")
numbers=list(f.read())
print(numbers)
f.close()
