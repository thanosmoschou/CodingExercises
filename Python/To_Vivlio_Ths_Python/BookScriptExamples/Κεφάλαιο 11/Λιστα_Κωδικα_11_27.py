# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-27. Επαναλήπτης nrange 
class nrange:
    '''Σαν την range, μόνο καλύτερη!!!'''
    def __init__(self, start=0, stop=0, step=1):
        self.start=start
        self.step=step

    def __iter__(self):
        return self

    def __next__(self):
        if self.start<self.stop:
            t=self.start
            self.start+=self.step
        else:
            raise StopIteration
        return t
