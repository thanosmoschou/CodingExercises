# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-31. Υπέρβαση & επέκταση μεθόδων 
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

    def invoice(self):
        print(f'Ποσό τιμολογίου:{self.price}')

class car(vehicle):
    def __init__(self,model,year,price,doors):
        super().__init__(model,year,price)
        self.doors=doors

    def info(self):
        super().info()
        print(f'Αρ.Θυρών:{self.doors}')

    def recall(self,yes=False):
        '''Η απόσυρση αφορά μόνο αυτοκίνητα
        και συνεπάγεται 10% έκπτωση στην τιμή'''
        print(f'{self.model}:{["Χωρίς","Με"][yes]} απόσυρση')
        print(f'{["Δεν έχει έκπτωση","Η έκπτωση είναι"][yes]} :{[0,0.1*self.price][yes]}')
        print(f'Αρχική τιμή: {self.price}-Τελική τιμή: {self. price+self.price*0.1*yes}')

    def invoice(self):
        print(f'Ποσό τιμολογίου:{self.price*1.24}')

class truck(vehicle):
    def __init__(self,model,year,price,weight):
        super().__init__(model,year,price)
        self.weight=weight        

    def info(self):
        super().info()
        print(f'Βάρος:{self.weight}')
