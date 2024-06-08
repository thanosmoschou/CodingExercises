# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-4. Αρχικοποίηση αντικειμένων με τη μέθοδο __init__ 
class Client:
    def __init__(self,name,balance=0):
        self.name=name
        self.balance=balance
c1=Client('Άννα',500)
c2=Client('Πέτρος')
print(c1.name, c1.balance)
for client in [c1,c2]:
    print(f'Πελάτης:{client.name},υπόλοιπο:{client.balance}')
