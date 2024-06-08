# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 8-17. Διαφορά – παραγγελίες 
products={'a1','a3','b2','b3','c1','c2'}#Ετοιμοπαράδοτα
order1={'a1','a2','b1','b2','c1','c3'}#Παραγγελία 1
order2={'a2','a3','b1','b4','c1','c2'}#Παραγγελία 2
newones=(order1|order2)-products
newlist=list(order1-products)+list(order2-products)
howmany={(x,newlist.count(x)) for x in newlist}
numofproducts=len(newones)
print(newones,howmany,numofproducts)
