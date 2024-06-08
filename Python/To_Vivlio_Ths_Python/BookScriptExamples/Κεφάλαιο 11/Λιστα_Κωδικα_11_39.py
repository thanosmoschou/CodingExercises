# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-39. Πολυμορφισμός κλάσεων 
class wv:
    def __init__(self,model):
        self.country='Γερμανία'
        self.model=model

    def maker(self):
        print(self.model)

class nissan:
    def __init__(self,model):
        self.country='Ιαπωνία'
        self.model=model

    def maker(self):
        print(self.model,self.country)

car1=nissan('Primera')
car2=wv('Polo')
cars=[car1,car2]
for car in cars:
    print(f'Μοντέλο:{car.model}')
    print(f'Προέλευση:{car.country}')
    print(car)
    car.maker()
