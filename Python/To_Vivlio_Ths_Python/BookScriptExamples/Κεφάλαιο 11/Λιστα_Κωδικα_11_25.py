# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-25. Υπερφόρτωση τελεστή πρόσθεσης 
    def __add__(self, other):
        if type(other)==tuple:
            p=self.x+other[0],self.y+other[1]
            return self.__class__(*p)#unpacking της πλειάδας
        x1=self.x+other.x
        y1=self.y+other.y
        return self.__class__(x1,y1)#αντικείμενο Point
