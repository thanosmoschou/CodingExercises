# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-37. Επικοινωνία αντικειμένων 
class Player:
    players=['Vilain','Hero']

    def hit(self,other):
        print(f'{self.__class__.players[isinstance(self,Hero)]} :Επίθεση...')
        other.kicked()

    def kicked(self):
        s='Αυτό πόνεσε...'
        print(f'{self.__class__.players[isinstance(self,Hero)]} :'+s)

class Hero(Player):
    pass

class Vilain(Player):
    pass
