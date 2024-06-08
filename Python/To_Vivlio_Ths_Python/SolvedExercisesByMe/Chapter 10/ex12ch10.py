"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def makeDict(msg):
    dict1 = {}
    list1 = []
    list1.extend(msg) #takes every character of the msg and passes it to the list as a different value. The split() would split the msg to objects when meeting space character or any character that i defined into the parenthesis 
    #print(list1)

    for item in list1:
        if dict1.get(item, 0) == 0: #if the letter does not exists create the record with value 1
            dict1[item] = 1
        else: #the letter already exists so increase the showing rate
            dict1[item] += 1

    return dict1

msg = input("Please enter your message: ")
print(makeDict(msg))