# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-21. Η βιβλιοθήκη os 
import os#εισαγωγη της βιβλιοθηκης os
os.getcwd()#επιστρέφει τον τρέχοντα κατάλογο
cwd=os.getcwd()#αποθηκεύει τον τρέχοντα κατάλογο …
print(cwd)#…σε μεταβλητή
os.listdir()#εμφανίζει τα περιεχόμενα του καταλόγου
dircont=os.listdir()
d=[x for x in dircont if x.endswith('txt')]
print(d)
os.chdir('..')#αλλαγή καταλόγου
os.chdir('..\code')
os.rename('sales.txt', 'sales.bac_')#αλλαγή ονόματος αρχείου
os.mkdir('test')#δημιουργεί νέο κατάλογο
os.remove('temp.txt')#διαγράφει ένα αρχείο
