# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-31. Market 
s=0
ans=input('Επόμενος Πελάτης (Ν/Ο)')
while ans.upper()=='N':
    s2=0
    price=float(input('Δώσε την τιμή:'))
    while price:
        pcs=float(input('Τεμάχια:'))
        val=price*pcs
        s2+=val
        price=float(input('Δώσε την τιμή:'))
    print('Αξία αγορών:',s2)
    s+=s2
    ans=input('Επόμενος Πελάτης (Ν/Ο)')
print('Συνολικά έσοδα',s)        
