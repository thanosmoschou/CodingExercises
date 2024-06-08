# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-30. Υπερκλάση vehicle 
class vehicle:
    def __init__(self,model,year,price):
        self.model=model
        self.year=year
        self.price=price

    def info(self):
        print('***Πληροφορίες***')
        print(f'Μοντέλο:{self.model}')
        print(f'Έτος κατασκευής:{self.year}')
        print(f'Τιμή:{self.price}')

class car(vehicle):
    def __init__(self,model,year,price,doors):
        super().__init__(model,year,price)
        self.doors=doors

    def info(self):#EXTENDS SUPER.INFO()
        super().info()
        print(f'Αρ.Θυρών:{self.doors}')

class truck(vehicle):
    def __init__(self,model,year,price,weight):
        super().__init__(model,year,price)
        self.weight=weight        

    def info(self):
        super().info()
        print(f'Βάρος:{self.weight}')
