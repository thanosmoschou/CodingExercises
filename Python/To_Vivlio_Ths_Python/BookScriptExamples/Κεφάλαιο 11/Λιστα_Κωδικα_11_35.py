# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-35. Ιδιωτικά χαρακτηριστικά 
class Employee:
    def __init__(self,name,salary):
        self.name=name
        self.__salary=salary
