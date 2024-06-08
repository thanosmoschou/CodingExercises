# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-33. Παράμετροι με διπλό αστερίσκο – βαθμοί 
def grades(name,**courses):
    print('Ο/H φοιτητής',name,'πηρε')
    for co,gr in courses.items():
        print('Μαθημα:',co,'Βαθμος:',gr)

grades('Γιωργος',C=6,Python=10)
grades('Εφη’, Αλγοριθμοι=8,Python=9,ASP=7)
