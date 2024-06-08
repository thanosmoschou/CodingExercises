"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

readyMessage = "My name is Thanasis.\nI am 19 years old and I am a student at UoM.\nA few days ago \
I finished my exam period.\nNow I am on vacation until I start to work as customer service agent at Vodafone."

vowels = "a e i o u"
vowels = vowels.split()
ctrVow = ctrSumf = 0

for char in readyMessage:
    if char in vowels:
        ctrVow += 1
    else:
        ctrSumf += 1

print(f"Fwnhenta: {ctrVow}\nSumfwna: {ctrSumf}")