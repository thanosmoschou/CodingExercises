# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-15. Επεξεργασία στοιχείων – συχνότητα λέξεων 
phrase=input('Δώσε μια πρόταση:') 
words={}
for word in phrase.split():
    words[word]=words.get(word,0)+1
print(words)
