# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#Λίστα Κώδικα 6-12. Έλεγχος τύπου αρχείων 
file='data.txt'
filetypes=('txt','asc','prn')
if file.endswith(filetypes):  
    print('Αρχείο κειμένου')  
else:
    print('Αρχείο άλλου τύπου')  
