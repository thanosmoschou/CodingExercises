# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-16. Επιστροφή αντικειμένων 
def shrink():
    y=list()
    for item in x:
        if item>0:
            y.append(item)
    return y

x=[1,-1,2,3,0,-4,4]
x1=shrink()
x=(1,2,-2,3)
x2=shrink()
x={-2,3,-1,4,0}
x3=shrink()
print(x1,x2,x3)
