# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-32. Χρήση κλάσης vehicle 
car1=car('Polo',2016,12000,5)
truck1=truck('Ford',2015,18000,3000)
car1.recall()    
car1.recall(True)
#truck1.invoice()
#car1.invoice()
for veh in [car1,truck1]:
    print(veh.model)
    veh.invoice()
