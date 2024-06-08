# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-13. Εισαγωγή στοιχείων – τιμές προϊόντων 
prices=dict(Α=5,Δ=12,Β=8) 
print(prices)
newprices=[('Α',8),('Ε',15),('Δ',10)] 
print(newprices)
for price in newprices:
    prices[price[0]]=price[1]
print(prices)
