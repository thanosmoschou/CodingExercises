# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-38. Ενσωματώνοντας συναρτήσεις 
import math
def f(x,y=3):
    return x**y
myfunctions=[abs,math.sqrt,f,lambda x:x**2]
myfunctions
 <function math.sqrt>,
 <function __main__.f>,
 <function __main__.<lambda>>]
myfunctions[0]
myfunctions[0](-2)
myfunctions[1](25)
myfunctions[2](2,5)
myfunctions[3](5)
for i in myfunctions:
    print(i(12), end=' ')
