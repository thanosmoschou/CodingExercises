# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-20. Ενημέρωση λεξικού 
salesA={2011:500,2013:400,2015:350,2016:500} 
salesB={2012:600,2014:500,2015:300,2016:200}
for key,val in salesB.items():
    if key in salesA:
        salesA[key]+=val
    else:
        salesA[key]=val
print(salesA)
