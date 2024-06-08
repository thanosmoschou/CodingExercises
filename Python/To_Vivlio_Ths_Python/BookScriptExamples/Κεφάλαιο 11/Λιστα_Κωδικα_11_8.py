# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-8. Μέθοδοι – αναλήψεις 
class Client:
    def __init__(self,name,balance=0):
        self.name=name
        self.balance=balance

    def deposit(self,amount):
        self.balance+=abs(amount)

    def withdrawal(self,amount):
        if abs(amount)<=self.balance:
            self.balance-=amount
            print(f'Το νέο υπόλοιπο είναι:{self.balance}€')
        else:
            print(f'Το υπόλοιπο {self.balance}€ δεν επαρκεί')
