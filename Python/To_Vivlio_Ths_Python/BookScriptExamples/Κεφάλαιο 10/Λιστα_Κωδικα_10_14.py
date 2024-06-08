# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-14. Επιστροφή τιμών 
def tetragona():
    s=0
    for i in range(101):
        s+=i**2
    return s

sum1=tetragona()
print('Το άθροισμα ειναι:',sum1)
