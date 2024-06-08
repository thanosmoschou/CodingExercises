# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-38. Ένα απλό παιχνίδι 
from random import randint
r=randint(0,1)
[Hero(),Vilain()][r].hit([Hero(),Vilain()][not r])        
