# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-41. Πολυμορφισμός σε υποκλάσεις 
class Bird:

    def isflying(self):
        print('Είναι πτηνό και πετάει...')

class Chicken(Bird):
    def isflying(self):
        print('Ανήκει στα πτηνά αλλά δεν πετάει')

class Eagle(Bird):
    pass

bird1,bird2=Eagle(),Chicken()
#ή birds=Eagle(),Chicken()
birds=bird1,bird2
for bird in birds:
    bird.isflying()
