# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-55. “Απλές” συναρτήσεις και συναρτήσεις γεννήτριες 
def makelist(n):
    x=[]
    for i in range(n):
        x.append(i)
    return x

def gmakelist(n):
    for i in range(n):
        yield i
