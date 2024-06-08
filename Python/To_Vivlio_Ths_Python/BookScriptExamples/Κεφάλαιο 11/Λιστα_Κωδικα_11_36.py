# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-36. Ελεγχόμενη πρόσβαση 
class Employee:
    def __init__(self,name,salary):
        self.name=name
        self.__salary=salary

    @property
    def salary(self):
        print(f'Ο μισθος είναι:')
        return self.__salary

    @salary.setter
    def salary(self,newsal):
        if newsal==''or newsal<0:
            print('Δώσατε λάθος στοιχεία!')
        else:
            self.__salary=newsal
        print(f'Μισθός:{self.__salary}')
