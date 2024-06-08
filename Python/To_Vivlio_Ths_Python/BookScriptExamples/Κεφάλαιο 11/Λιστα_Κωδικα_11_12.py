# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-12. Μέθοδοι κλάσης 
class Client:
    total=0
    transactions=[]
#Περιέχονται όλες οι προηγούμενες μέθοδοι
    @classmethod #1
    def numtrans(cls):
        return f'Έγιναν {len(cls.transactions)} συναλλαγές'

    @classmethod   #2:factory
    def noname(cls):
        return cls('',0)
