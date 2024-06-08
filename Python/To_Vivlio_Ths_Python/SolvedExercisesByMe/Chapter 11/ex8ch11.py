"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

weapons = ['Spathi', 'Flogovolo', 'Oplo', 'Maxairi']
topothesies = ['Nisi', 'Spilia', 'Ktirio']

class Location:
    def __init__(self, name, role):
        self.oplo = weapons[randint(0, len(weapons) - 1)]
        self.location = topothesies[randint(0, len(topothesies) - 1)]
        self.name = name
        self.role = role

    def moveToLocation(self):
        while True: #validity check
            index = int(input(f'\nPlease select:\n1.{topothesies[0]}\n2.{topothesies[1]}\n3.{topothesies[2]}\n'))
            if index < 1 or index > len(topothesies): #o xrhsths dinei index me arxi to 1. Sto telos tha afaireso 1 gia na paro ta stoixeia ths listas
                print('Please enter valid data...')
            else:
                break
        self.location = topothesies[index - 1]

    def selectWeapon(self):
        while True:
            index = int(input(f'\nPlease select:\n1.{weapons[0]}\n2.{weapons[1]}\n3.{weapons[2]}\n4.{weapons[3]}\n'))
            if index < 1 or index > len(weapons):
                print('Please enter valid data...')
            else:
                break
        self.oplo = weapons[index - 1]

    def fight(self, other):
        self.win = randint(0, 1)
        other.win = 0 if self.win else 1 #to anapodo apo to self.win
        print(f"\nHero VS Villain\nHero's location: {self.location}\nVillain's location: {other.location}\nHero's weapon: {self.oplo}\n\
Villain's weapon: {other.oplo}\nWinner is: {self.role if self.win else other.role}")
        

class Hero(Location):
    def __init__(self, name, role):
        super().__init__(name, role)

class Villain(Location):
    def __init__(self, name, role):
        super().__init__(name, role)

max = Hero('max', 'Hero')
george = Villain('george', 'Villain')
max.moveToLocation()
george.moveToLocation()
max.selectWeapon()
george.selectWeapon()
max.fight(george)
george.fight(max)
