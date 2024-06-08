# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-11. Στατικές μέθοδοι 
class Client:
    total=0
    transactions=[]

    @staticmethod
    def showclients():
        return f'{list(set([x[1] for x in Client.transactions]))}'
#Περιέχονται όλες οι προηγούμενες μέθοδοι
    def showtrans(self):
        t=[x[0::2] for x in self.__class__.transactions if x[1]==self.name]
        print(f'Κινήσεις που έκανε ο πελάτης {self.name}:{t}')
