# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-13. Εγγραφή αρχείου με τη writelines 
file1=open('data.txt','r'))
file2=open('data.back.txt','w')
data=file1.readlines()
file2.writelines(data)
file1.close()
file2.close()
file1=open('data.back.txt','r')
data=file1.readlines()
print(data)
file1.close()
