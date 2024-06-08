# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-49. Πλήθος ψηφίων με αναδρομή 
n=234567

def digits(n):
    n=n//10
    if n==0:
        return 1
    else:
        return digits(n)+1

print(digits(n))
