"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

class Vector:
    def __init__(self, list1):
        self.periexom = list(list1)

    def esoterGinom(self, other):
        ginom = sum([self.periexom[i] * other.periexom[i] for i in range(len(self.periexom))]) #idia diastasi exoyn ta vectors, allios den doulevei
        return f'{self.periexom} * {other.periexom} = {ginom}'

    def prosthesiVec(self, other):
        sumVec = []
        for i in range(len(self.periexom)):
            sumVec.append(self.periexom[i] + other.periexom[i])
        
        return f'{self.periexom} + {other.periexom} = {sumVec}'

vec1 = Vector([randint(1, 10) for i in range(5)])
vec2 = Vector([randint(1, 10) for i in range(5)])

print(vec1.periexom, vec2.periexom, vec1.esoterGinom(vec2), vec2.esoterGinom(vec1), vec1.prosthesiVec(vec2), vec2.prosthesiVec(vec1), sep = '\n')