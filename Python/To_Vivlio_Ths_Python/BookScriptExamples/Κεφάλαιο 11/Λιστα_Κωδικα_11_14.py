# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-14. Ειδικές μέθοδοι – len,call,getitem κ
class Client:
    total=0
    transactions=[]
# Οι υπόλοιπες μέθοδοι μπαίνουν εδώ

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
          for i,item in enumerate(self.__class__.transactions):        self.__class__.transactions[pos]=val
               if item[1]==self.name:
                   if t==pos:
                       self.__class__.transactions[i]=val
                       break
               t+=1

    def __reversed__(self):
        return list(reversed(self.gettrans()))

    def __repr__(self):
        return f'Αντικείμενο {self.__class__.__name__}-Πελάτης {self.name}'
