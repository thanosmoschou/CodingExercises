# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-31. Παράμετροι με αστερίσκο – βαθμοί 
def grades(name,*courses):
    print('Ο/H φοιτητής',name,'πηρε')
    for c in courses:
        print(c)

grades('Γιωργος','C',6,'Python',10)
grades('Εφη','Αλγοριθμοι',8,'Python',9,'ASP',7)
