# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#Λίστα Κώδικα 6-9. Χρήση της unicodedata 
import unicodedata
s='οι γλώσσες προγραμματισμού'  
s=''.join(char for char in unicode.normalize('NFD',s) 
... if unicodedata.category(char)!='Mn')
