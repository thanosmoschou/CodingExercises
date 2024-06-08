"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis\n I am 19 years old and I am a student at UoM.\nA few days ago \
I finished my exam period.\nNow I am on vacation until I start to work as customer service agent at Vodafone."

list1 = []
ctr = 0

for char in readyMessage:
    found = False
    if char != ' ' and char != '\n' and not char.isdigit():
        for ctr2 in range(len(readyMessage)):
            if char == readyMessage[ctr2] and ctr2 != ctr:
                found = True
                break
        if not found:
            list1.append(char)
    ctr += 1

print("Letters that are not repeating in the message:\n", list1)