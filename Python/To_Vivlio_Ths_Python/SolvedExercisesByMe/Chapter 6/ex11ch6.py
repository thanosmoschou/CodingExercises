"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis.\tI am 19 years old and I am a student at UoM.\nA few days ago \
I finished my exam period.\tNow I am on vacation until I start to work as customer service agent at Vodafone."

replace = readyMessage.maketrans({" ":"", "\t":""})
readyMessage = readyMessage.translate(replace)

print(readyMessage)