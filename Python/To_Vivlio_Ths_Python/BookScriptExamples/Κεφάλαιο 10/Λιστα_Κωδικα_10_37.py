# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-37. Κλείσιμο – εμφάνιση μηνύματος 
def msg1(hello):
    def msg2(world):
        return hello+' '+world
    return msg2

msga=msg1('Άκου')
msgb=msg1('Η python')
print(msga('κόσμε...'),msgb('τα... σπάει!'))
