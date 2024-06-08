"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis. I am 19 years old and I am a student at UoM. A few days ago \
I finished my exam period and now I am on vacation until I start to work as customer service agent at Vodafone."

inputMessage = input("Please enter a word: ")

list1 = readyMessage.split()
print(list1)

print("Words on the standard message that contain the inserted word are:")
for ctrWord in range(len(list1)):
    if list1[ctrWord].find(inputMessage) != -1:
        print(list1[ctrWord])