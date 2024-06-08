# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-17. Υπερφόρτωση τελεστών – γενικό άθροισμα 
class Client:
# Οι υπόλοιπες μέθοδοι μπαίνουν εδώ
    def __add__(self, other):
        if type(other)==type(self):
            return self.balance+other.balance
        return self.balance+other
