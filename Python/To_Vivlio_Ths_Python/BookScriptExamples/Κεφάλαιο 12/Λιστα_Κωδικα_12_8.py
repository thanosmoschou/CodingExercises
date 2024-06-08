# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-8. Ανάγνωση αρχείου με while 
f=open("sales2.txt")
line=f.readline()
sales=[]
while line:
    sales+=line.split()
    line=f.readline()
x=[int(x) for x in sales if x.isnumeric()]
print(f'Η λίστα με τις πωλήσεις:{x}')
print(f'Συνολικές πωλήσεις:{ sum(x)}')
f.close()
