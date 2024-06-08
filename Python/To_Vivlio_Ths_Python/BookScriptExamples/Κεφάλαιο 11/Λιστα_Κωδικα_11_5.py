# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-5. ΠΕΡΙΕΧΟΜΕΝΑ ΑΡΧΕΙΟΥ BANK.PY ΜΕ ΤΟΝ ΟΡΙΣΜΟ ΤΗΣ ΚΛΑΣΗΣ CLIENT
class Client:
    def __init__(self,name,balance=0):
        self.name=name
        self.balance=balance
