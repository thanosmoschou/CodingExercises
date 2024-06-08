"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

class Pet:
    def __init__(self, eidos, age, weight):
        self.eidos = eidos
        self.age = age
        self.weight = weight
        
    def infoFood(self):
        print(f'Eidos: {self.eidos}\nHlikia: {self.age}\nVaros: {self.weight}')
        print(f'To eidos: {self.eidos} trefetai me: {self.food} kai kanei {self.sound}')

class Dog(Pet):
    def __init__(self, eidos, age, weight, food, sound):
        super().__init__(eidos, age, weight)
        self.sound = sound
        self.food = food

class Cat(Pet):
    def __init__(self, eidos, age, weight, food, sound):
        super().__init__(eidos, age, weight)
        self.sound = sound
        self.food = food
    
class Parrot(Pet):
    def __init__(self, eidos, age, weight, food, sound):
        super().__init__(eidos, age, weight)
        self.sound = sound
        self.food = food

maximus = Dog('Skilos', 2, 30, 'Skilotrofi', 'Wooof Wooof')
claudia = Cat('Gata', 1, 3, 'Gatotrofi', 'Meowww')
george = Parrot('Papagalos', 1, 2, 'Sporia', 'Tsiou Tsiou')

maximus.infoFood(), claudia.infoFood(), george.infoFood()