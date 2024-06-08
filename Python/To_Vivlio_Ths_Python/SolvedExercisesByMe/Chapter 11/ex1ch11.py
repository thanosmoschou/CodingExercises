"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

pi = 3.14

class Sxima:
    def info(self): #self dilonei to antikeimeno ths klasis. Panta h 1h parametros olon ton methodon antistixizetai sto antikeimeno tis klasis xoris omos na to pernao os orisma otan kalo thn methodo. Sumvasi na to leme self
        print(f'Sxima: {self.name}\nPlevres: {self.plevres}')


class Circle(Sxima):
    def __init__(self, name, aktina, plevres = 0):
        self.name = name
        self.aktina = aktina
        self.plevres = plevres

    def findEmvado(self):
        self.emvado = pi * (self.aktina ** 2)
        super().info() #mporo tin uperklasi apo tin opoia proerxontai na tin kaleso os super() kai tin methodo pou thelo or tin idiothta
        print(f'Emvavo tou sximatos {self.name}: {self.emvado}')

class Orthogonio(Sxima):
    def __init__(self, name, vasi, upsos, plevres = 4):
        self.name = name
        self.vasi = vasi
        self.upsos = upsos
        self.plevres = plevres

    def findEmvado(self):
        self.emvado = self.vasi * self.upsos
        super().info()
        print(f'Emvado tou sximatos {self.name}: {self.emvado}')

    
sxima1 = Circle('Kyklos', 5)
sxima2 = Orthogonio('Orthogonio', 5, 6)

sxima1.findEmvado()
sxima2.findEmvado()