"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def calcSumList(list1):
    retList = []

    #I want to move within the list so i use the for loop in order to have indexes in the list.
    #Now i want to sum all the elements until this index. This is the role of the 2nd for loop.
    for i in range(len(list1)):
        sum = 0
        for j in range(i + 1): #i want the current position's element also
            sum += list1[j]
        retList.append(sum)
    
    return retList

list1 = [randint(0, 5) for x in range(10)] #list comprehension 
print(f"First List with numbers: {list1}", f"List with improving sums: {calcSumList(list1)}", sep = '\n')