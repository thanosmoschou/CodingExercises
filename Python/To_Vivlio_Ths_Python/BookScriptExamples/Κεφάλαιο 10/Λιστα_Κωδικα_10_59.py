# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-59. Module area.py
# -*- coding: utf-8 -*-
"""
Μονάδα κώδικα για τον υπολογισμό εμβαδού γεωμετρικών σχημάτων
@author: book authors
"""

pi=3.1415926535

def square(a=1):
    return a**2

def rect_orh(a=1,b=1):
    return a*b

def rect(b=1,y=1):
    pass

def circle(r=1):
    pass

def trap(b1,b2,y):
    pass

def rhombus(d1,d2):
    pass

def triangle(b,y):
    pass

#testing 
if __name__=='__main__':
    print(f'Η τιμή του π, με ακρίβεια 10 ψηφίων:{pi}')
    print('Αν βλέπεις μια τιμή του π, τότε είναι όλα εντάξει!')
