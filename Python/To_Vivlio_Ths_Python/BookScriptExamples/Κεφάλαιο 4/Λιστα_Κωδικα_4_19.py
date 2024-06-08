# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-19. while – διακοπή εισαγωγής στοιχείων 
#Χρήση της for με break
s=0
for i in range(10):
    x=int(input('Δώσε έναν ακέραιο:'))
    s+=x
    if s>100:
        break
#Χρήση while με σύνθετη συνθήκη 
i=s=0
while s<=100 and i<10:
    x=int(input('Δώσε έναν ακέραιο:'))
    i+=1
    s+=x
#Χρήση της while με break
s=i=0
while True:
    x=int(input('Δώσε έναν ακέραιο:'))
    s+=x
    i+=1
    if s>100 or i==10:
        break
