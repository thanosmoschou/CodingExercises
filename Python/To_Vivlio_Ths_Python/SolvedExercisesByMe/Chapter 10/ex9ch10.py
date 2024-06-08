"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

global limLottNum
limLotNum = 5 #this is the limit of the different numbers i want to have in the lottery

def lotteryNumbers(listLott):
    ctrDiffNum = 0
    while ctrDiffNum <= limLotNum:
        lotNum = randint(1, 49)
        foundSameNum = False
    
        for item in listLott: #search if this number already exists in the list
            if item == lotNum:
                foundSameNum = True
                break #go to the next number
        
        if not foundSameNum:
            listLott.append(lotNum)
            ctrDiffNum += 1

    for i in range(limLotNum): #generate each number separately
        yield listLott[i]

list1 = []
#i must have a reference to the generator. Otherwise i cannot use it. Now the generator is accessible from generator variable
#Now the lotteryNumbers() is not running directly and is accessible from generator variable
generator = lotteryNumbers(list1) 
for i in range(limLotNum):
    print(next(generator))