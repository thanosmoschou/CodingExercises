# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-8. Η εντολή global 
lang='Java'

def learnnewthings():
    global lang
    print('Χρησιμοποιούσα',lang)
    lang='Python'
    print('αλλά τώρα όμως μαθαίνω',lang)

print('Είχα μάθει',lang)
learnnewthings()
print('και η',lang,'μου αρέσει')
