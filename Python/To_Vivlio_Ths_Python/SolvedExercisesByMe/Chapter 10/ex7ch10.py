"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def checkDivConditions1(div1): #use the closure attribute of python. Check theory for more
    def checkDivConditions2(a, b):
        if b == 0:
            return f'This division cannot be done'
        return div1(a, b)
    return checkDivConditions2

@checkDivConditions1 #decoration to the makediv function with checkdivitions1 function. Use @ and the name of the decorator before the function you want to decorate
def makeDiv(num1, num2):
    return num1 / num2

num1, num2 = [randint(0, 5) for x in range(2)]
print(num1, num2, f'{num1}/{num2} = {makeDiv(num1, num2)}', sep = '\n')

#2nd way
d = checkDivConditions1(makeDiv) #pass the name of the function you want to decorate to the function that is the decorator
#then on the d is the reference to the function that is defined into the chekConditions function. Now i can call the 
#checkConditions2 function just using the d(). I cannot use checkDivConditions function because its scope is not allowing it to be used outside of the checkDivConditions1 function
#this is the decoration using the closure in python
print(d(num1, num2))