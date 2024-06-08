# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-26. Ατέρμων επαναλήπτης 
class infrange:# infinite iterator
    def __init__(self, start=0, step=1):
        self.start=start
        self.step=step
    
    def __iter__(self):
        return self

    def __next__(self):
        t=self.start
        self.start+=self.step
        return t
