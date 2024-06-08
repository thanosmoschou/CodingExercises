# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-23. Ορισμός κλάσης client 
from functools import total_ordering
@total_ordering
class Client:
    total=0
    transactions=[]

    @staticmethod
    def showclients():
        return f'{list(set([x[1] for x in Client.transactions]))}'

    def __init__(self,name,balance=0):
        self.name=name
        self.balance=balance
        self.transaction(balance)
        if balance!=0:
            self.__class__.transactions.append(('Πίστωση',self.name,balance))

    def withdrawal(self,amount):
        if abs(amount)<=self.balance:
            self.balance-=amount
            self.__class__.transactions. append(('Χρέωση',self.name,-amount))
            self.transaction(-amount)
        else:
            print(f'Το υπόλοιπο {self.balance}€ δεν επαρκεί')

    def deposit(self,amount):
        self.balance+=abs(amount)
        self.__class__.transactions.append(('Πίστωση',self.name,amount))
        self.transaction(amount)

    def transaction(self,amount):
        self.__class__.total+=amount

    def showtrans(self):
        print(f'Κινήσεις πελάτη:{self.name}:{self.gettrans()}')

    def gettrans(self):
        return [x[0::2] for x in self.__class__.transactions if x[1]==self.name]

    def __len__(self):
        return len(self.gettrans())

    def __call__(self):
        return self.gettrans()

    def __getitem__(self,pos):
        return self.gettrans()[pos]

    def __setitem__(self,pos,val):
        t=0
        for i,item in enumerate(self.__class__.transactions):
            if item[1]==self.name:
                if t==pos:
                    self.__class__.transactions[i]=val
                    break
                t+=1

    def __eq__(self,other):
        same=['Όχι, δεν','Ναι,']
        s=' έχουν ίδιο υπόλοιπο'
        return f'{same[self.balance==other.balance]}'+s

    def __add__(self, other):
        if type(other)==type(self):
            return self.balance+other.balance
        return self.balance+other

    def __lt__(self, other):
        return self.balance<other.balance

    def __repr__(self):
        return f'{self.__class__.__name__}-Πελάτης {self.name}'

    def __str__(self):
        return f'Όνομα πελάτη: {self.name}'
