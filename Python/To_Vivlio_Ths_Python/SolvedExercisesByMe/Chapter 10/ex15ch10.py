"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def findSum(*tuple1): #* means that the numbers of arguments is unknown and they pass to thhe function as a tuple. ** means that i have a dictionary
    sum1 = ()

    for item in tuple1: #take every object of the tuple. There are lists as objects in the tuple
        tempSum = 0
        for tempItem in item: #now sum all the inside values of the object that you took in the previous level loop
            tempSum += tempItem
        sum1 += tempSum, #create new tuple with all the old values and the new one
    
    return sum1

print(*findSum([randint(0, 10) for x in range(10)]), *findSum([randint(0, 5) for x in range(7)], [randint(0, 40) for x in range(20)]), sep = '\n') #pass different amount of arguments everytime and * means that i unpack the values of the tuple