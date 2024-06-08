"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def findMinMax(num1, num2, num3):
    minNum = num1 if num1 < num2 and num1 < num3 else (num2 if num2 < num3 else num3) #1 line if. We 
    #do not need to compare num1 with num2 in the else section because the num1 is not the minimum if the first section failed to be True

    maxNum = num1 if num1 > num2 and num1 > num3 else (num2 if num2 > num3 else num3)
    #We do not need to compare num1 with num2 in the else section because the num1 is not the maximum if the first section failed to be True

    return minNum, maxNum

num1, num2, num3 = [randint(0, 100) for x in range(3)] #unpacking the list

print(f'Numbers are: {num1, num2, num3}')
print("Min = {0}\nMax = {1}".format(*findMinMax(num1, num2, num3))) #use the * to unpack the tuple and not showing the result like (val1, val2)