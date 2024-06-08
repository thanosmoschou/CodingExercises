# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-33. Ταξινόμηση 
d=dict(c=12,b=3,a=8) 
x=sorted(d.keys())
y=sorted(d.values())
z=list(d.keys()).sort()
x2=sorted(d.keys(),reverse=True)
w=sorted(d.items(),key=lambda item:item[1])
