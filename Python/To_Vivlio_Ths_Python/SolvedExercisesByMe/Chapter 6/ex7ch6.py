"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis . I am 19 years old and I am a student at UoM . A few days ago \
I finished my exam period and now I am on vacation until I start to work as customer service agent at Vodafone ."

inputMessage = input("Please enter a message: ")

list1 = readyMessage.split()
list2 = inputMessage.split()

for i in range(len(list2)):
    ctr1 = 0
    for j in range(len(list1)):
        if list2[i] == list1[j]:
            ctr1 += 1
    print(list2[i], ctr1)