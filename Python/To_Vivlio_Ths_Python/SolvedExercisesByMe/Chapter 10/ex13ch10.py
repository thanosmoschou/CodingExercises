"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#In order to work the lists must have the same length. Otherwise the attributes of union, intersection and difference are invalid
from random import randint

def intersecLists(lis1, lis2):
    intersecSet = set()

    for item1 in lis1:
        for item2 in lis2:
            if item1 == item2:
                intersecSet.add(item1) #i could use a list but i must check if the value already exists in the union list. So i use set to make my life easier
    
    return intersecSet


def unionLists(lis1, lis2):
    unionSet = set()

    for item in lis1:
        unionSet.add(item)
    
    for item in lis2:
        unionSet.add(item)
    
    return unionSet


def differenceList(lis1, lis2): #this will find all the values of the list1 that are not in the list2
    diffSet = set() #do not use diffSet = {} because you will create an empty dictionary

    for item1 in lis1:
        found = False
        for item2 in lis2:
            if item1 == item2: #this is not different value
                found = True
                break
        if not found : #different value
            diffSet.add(item1)
    
    return diffSet


list1, list2 = [randint(0, 20) for x in range(10)], [randint(0, 20) for x in range(10)]
print(f'List1 = {list1}\nList2 = {list2}\nUnion = {unionLists(list1, list2)}\nIntersection = {intersecLists(list1, list2)}\nDifference = {differenceList(list1, list2)}')