# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-9. Ανάγνωση αρχείου και επεξεργασία 
def isnum(x):
    try:
        x=float(x)
    except ValueError:
        return False
    return True
f=open("sales3.txt")
line=f.readline()
sales=[]
while line:
    sales+=line.split()
    line=f.readline()
x=[float(x) for x in sales if isnum(x)]
f.close()
print(f'Η λίστα με τις πωλήσεις:{x}')
print(f'Συνολικές πωλήσεις:{sum(x)}')
