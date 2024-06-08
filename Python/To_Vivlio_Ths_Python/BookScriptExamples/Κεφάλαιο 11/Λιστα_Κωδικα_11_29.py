# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-29. Κλάσεις οχημάτων 
class car:
    def __init__(self,model,year,price,doors):
        self.model=model
        self.year=year
        self.price=price
        self.doors=doors

    def info(self):
        print('***Πληροφορίες***')
        print(f'Μοντέλο:{self.model}')
        print(f'Έτος κατασκευής:{self.year}')
        print(f'Τιμή:{self.price}')
        print(f'Αρ.Θυρών:{self.doors}')

class truck:
    def __init__(self,model,year,price,weight):
        self.model=model
        self.year=year
        self.price=price
        self.weight=weight

    def info(self):
        print('***Πληροφορίες***')
        print(f'Μοντέλο:{self.model}')
        print(f'Έτος κατασκευής:{self.year}')
        print(f'Τιμή:{self.price}')
        print(f'Βάρος:{self.weight}')

car1=car('Polo',2016,12000,5)
truck1=truck('Ford',2015,18000,3000)
car1.info()
truck1.info()
