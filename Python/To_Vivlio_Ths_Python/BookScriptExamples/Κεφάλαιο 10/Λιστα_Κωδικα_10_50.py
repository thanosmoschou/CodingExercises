# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-50. Ακολουθία Fibonacci με αναδρομή 
n=7

def fib(n):
    if n==1 or n==2:
        return 1
    elif n==0:
        return 0
    else:
        return fib(n-1)+fib(n-2)

print(fib(n))
