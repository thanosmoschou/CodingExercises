# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 5-22. H συνάρτηση sorted σε λιστες 
sales=[2000,3500,1800,2700,4200]
names=['Αννα','Εύα','Γιώργος','Γιάννης','Εφη']
snames = [name for _,name in sorted(zip(sales,names),reverse=True)]
print(snames)
