# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-20. Χρήση παραμέτρων – φιλτράρισμα 
def shrink(x):
    y=list()
    for item in x:
        if item>0:
            y.append(item)
    return y

a=(1,-1,2,3,0,-4,4)
b=[1,2,-2,3]
c={-2,3,-1,4,0}
a=tuple(shrink(a))
b=shrink(b)
c2=shrink(c)
print(a,b,c2)
