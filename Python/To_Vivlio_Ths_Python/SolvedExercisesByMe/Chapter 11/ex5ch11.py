"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

class Sxol:
    def __init__(self, school, am, name):
        self.school = school
        self.name = name
        self.am = am

class Stud(Sxol):
    def __init__(self, school, name, am, vathmoi):
        super().__init__(school, am, name)
        self.vathmoi = list(vathmoi)
    
    def info(self):
        print(f'Sxoleio: {self.school}\nMathitis: {self.name}\nAM: {self.am}\nAnalytiki vathmologia: {self.vathmoi}\n')

class Teacher(Sxol):
    def __init__(self, school, name, am, mathimataDidask):
        super().__init__(school, am, name)
        self.mathimataDidask = list(mathimataDidask)
    
    def info(self):
        print(f'Sxoleio: {self.school}\nDaskalos: {self.name}\nAM: {self.am}\nMathimata pou didaskei: {self.mathimataDidask}\n')


george = Stud('1o Dimotiko Nikaias', 'Giorgos', 1234, [randint(0, 10) for i in range(4)])
mrKostas = Teacher('2o Dimotiko Petralonon', 'Kostas', 4567, ['Glossa', 'Mathimatika', 'Fisiki', 'Pliroforiki'])

george.info()
mrKostas.info()
print(george, mrKostas)