"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis.\nI am 19 years old and I am a student at UoM.\nA few days ago \
I finished my exam period.\nNow I am on vacation until I start to work as customer service agent at Vodafone."

list1 = []
i = 0

for char in readyMessage:
    insertStuff = char
    insertStuff = insertStuff + " " + str(ord(char)) + " " + str(i)
    list1.append(insertStuff)
    i += 1
    
print(list1)