# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-39. Συναρτήσεις παράμετροι 
import math
functions=[abs,math.log10,math.sin,math.cos]

def menu():
    print('Έπιλεξτε: \n0:abs\n1:log10\n2:sin\n3:cos')
    choice=int(input())
    num=eval(input('Δώσε και έναν αριθμό:'))
    return choice, num

def calc(func,x):
    return func(x)
    
choice,num=menu()
ans=calc(functions[choice],num)
print('Το αποτέλεσμα είναι:',ans)
