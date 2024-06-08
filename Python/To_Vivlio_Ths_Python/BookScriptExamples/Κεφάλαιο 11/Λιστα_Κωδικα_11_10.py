# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-10. Χειρισμός ιδιοτήτων κλάσης 
class Client:
    total=0
    transactions=[]
    def __init__(self,name,balance=0):
        self.name=name
        self.balance=balance
        self.transaction(balance)
        if balance!=0:
            self.__class__.transactions.append(('Πίστωση', self.name,balance))

    def withdrawal(self,amount):
        if abs(amount)<=self.balance:
            self.balance-=amount
            self.__class__.transactions.append(('Χρέωση', self.name,-amount))
            self.transaction(-amount)
        else:
            print(f'Το υπόλοιπο {self.balance}€ δεν επαρκεί για ανάληψη.')

    def deposit(self,amount):
        self.balance+=abs(amount)
        self.__class__.transactions.append(('Πίστωση', self.name,amount))
        self.transaction(amount)

    def transaction(self,amount):
        self.__class__.total+=amount
