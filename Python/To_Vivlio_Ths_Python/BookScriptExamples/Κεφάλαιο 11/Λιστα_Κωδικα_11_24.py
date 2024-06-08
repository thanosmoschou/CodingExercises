# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 11-24. Σημεία στο επίπεδο 
class Point:
    def __init__(self,x=0,y=0):
        self.x=x
        self.y=y
    
    def __add__(self, other):
        x1=self.x+other.x
        y1=self.y+other.y
        return self.__class__(x1,y1)    

    def distance(self,other):
        from math import sqrt
        d=sqrt((other.x-self.x)**2+(other.y-self.y)**2)
        return f'Απόσταση Σημείων {d}'
    
    def __str__(self):
        return f'Σημείο: ({self.x},{self.y})'
p1=Point(1,2)
p2=Point(0,5)
p3=Point()
print(f'{p1},{p2},{p3}')
print(p1+p2)
print(p1.distance(p2))
