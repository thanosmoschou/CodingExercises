"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis.\nI am 19 years old and I am a student at UoM.\nA few days ago \
I finished my exam period.\nNow I am on vacation until I start to work as customer service agent at Vodafone."

encryptedMessage = "\0"

key = int(input("Please enter the key for the Ceasar Encryption Algorithm: "))

for char in readyMessage:
    if char != '\n':
        newChar = ord(char) + key
        newChar = chr(newChar)
        encryptedMessage = encryptedMessage + newChar
    else:
        encryptedMessage = encryptedMessage + char

print(encryptedMessage)