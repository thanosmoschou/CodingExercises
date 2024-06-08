#!/usr/bin/env python3

'''
Author: Thanos Moschou
Date: 06/2023
Description: This is a small cheatsheet about python list methods and functions
The methods and functions that are in this cheatsheet are the following

->list
->deepcopy
->append
->insert
->extend
->del
->remove
->pop
->clear
->sort
->reverse
->sorted
->count
->index
->len
->max, min
->all, any

'''

import copy

#create a new list
myList = [] #or myList = list(empty or with an iterative object here like strings, tuples or other lists) ... myList = list('python'), myList = list((1,2,3))

#check if it is a list
print(type(myList))

#list comprehension
#one line if -> variable = value if condition else otherValue ... and with for is -> variable = value for value in sequence if condition else otherValue ... in both cases else section is not mandatory

v = [1,2,3,4,5,6,7]
someOtherList = [item for item in v if item % 2 == 0] #variable = [x for x in sequence if condition else y], or variable = [x if condition else y for x in sequence] if you want to use if else in list comprehension
print(someOtherList)


#initialize a list
aList = [0, 0, 0] #or if the initial values are the same aList = [value]*totalPlacesInsideTheList (this is overloading of operator *)... value can be None also

#aList = ['1', 1, 3, 'ab']

#traverse a list
myList = [1,2,3,4,5]

print(myList[1]) #print the second value
print(myList[-1]) #print the last value

for item in myList:
    print(item)

#len returns the length of the list
#range returns a sequence of numbers in some range: range(0, 10) -> [0, 10), range(10) -> [0, 10), range(1, 10, 2) -> [1,10) with step 2, range(-1, -4, -1) -> -1, -2, -3 or (-4, -1]
for i in range(len(myList)):
    print(myList[i])


#return the reverse of the list
for i in range(-1, -len(myList) - 1, -1):
    print(myList[i])

#slicing -> myList[index1: index2: index3] -> same as range...index2 is necessary
print(myList[:3])
print(myList[::-1])


#copy of the list
someList = myList #every change in myList affects someList because they are the same reference to myList

print(id(someList), id(myList)) #check the id of an object


#take a deepcopy

second = copy.deepcopy(myList)
#now any change to myList wont affect second

#append
myList.append('v') #any value you want...either a list but it would be representated as a list...it won't take the values from inside and place them to the list. Append returns None so be careful not to assign the return value

print(myList)

#insert
myList.insert(3, 2) #insert at position 3 the value 2...all the values after position 3 will be moved one place after

#extend
myList.extend(['a', 2, 4]) #now the values inside the given list will be taken individually

print(myList)

#delete
#del myList

#print(myList) now myList not exist in the namespace

#you can use del to clear the values from inside and not delete the object from the namespace
#del myList[:]

#remove

myList.remove(2) #remove the first value of the list that is equal to 2

#pop

myList.pop() #or myList.pop(index)


#clear
myList.clear() #clear the values from the list

#reverse the list
myList.reverse()

#sort the list
myList.sort() #myList.sort(key, reverse) -> myList.sort(key=aFunctionNameWithoutParentheses, reverse=eitherTrueOrFalse) -> myList.sort(key=abs, reverse=True)

#sorted returns a sorted list without modifying the initial
secondList = sorted(myList)


#count
threes = myList.count(3) #get the amount of threes inside the list

#index -> return the index of the object in the list...only the first index will be returned in case that object exists multiple times
#variable = myList.index(3, 0, -2) #list.index(object, start, end)

#max min
myList = [1,2,3]
print(max(myList), min(myList))

#any, all
print(any(myList)) #check if a value is non zero

print(all(myList)) #check if all values are non zero

#unpack
var1, var2, var3 = [1,2,3]
print(var1, var2, var3)

var4, var5, *var6 = [3,4,5,6,7,8] #var4 and var5 will have one value and the remaining values will be assigned to var6 as a list
print(var4, var5, var6)
