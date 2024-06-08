# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-27. Πολλαπλή επεξεργασία – υπόλοιπα πελατών 
transactions=dict(Γιωργος=300,Αννα=200,Νίκη=0)  
trback=dict(Γιωργος=300,Εφη=1500,Νίκη=0,)
client=input('Δώσε το όνομα του πελάτη:')
amount=transactions.setdefault(client,trback[client])
print(f'Το υπόλοιπο του πελάτη {client} είναι {amount}')
print(transactions)
