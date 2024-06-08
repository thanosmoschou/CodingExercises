# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-28. Κλάση για τις δυνάμεις του 2 
class Pow2:
    def __init__(self,begin=0,end=1):
        self.val=begin-1
        self.end=end

    def __iter__(self):
        return self

    def __next__(self):
        if self.val==self.end:
            raise StopIteration
        self.val+=1
        return 2**self.val
