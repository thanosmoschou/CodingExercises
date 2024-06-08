"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def generatePosFromLinearSearch(list):
    for i in range(len(list)):
        yield i

randNum = randint(0, 10)
list = [randint(0, 10) for x in range(20)]

gen = generatePosFromLinearSearch(list)
for i in range(len(list)):
    print(f'Next possible position in the list that may contains number {randNum} = {next(gen)}')

    while True:
        global choice 
        choice = input('Continue (Y/N)? ')
        if choice.upper() != 'N' and choice.upper() != 'Y':
            print("Enter valid data...")
        else:
            break
    
    if choice.upper() == 'N':
        break