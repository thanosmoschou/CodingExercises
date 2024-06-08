# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-15. Επιστροφή περισσότερων τιμών 
def minmax():
    if a>b:
        return b,a
    else:
        return a,b
a,b=10,5
min1,max1=minmax()
print('Μικροτερος:',min1,'Μεγαλυτερος:',max1)
#ή
t=minmax()
print('Σε πλειάδα:(min,max)=',t)
#ή
print('Σε πλειάδα μέσα σε άλλη συνάρτηση:(min,max)=',minmax())
