"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

initial_number = int(input("Insert a 3-digit number: "))

# Pairno to kathe psifio enos arithmou me ton eksis tipo:
# psifio = (arithmos % (10)^(i+1)) / 10^i opou / ennoo div kai i isoutai me
#tin thesi tou psifiou: 0 gia monades, 1 gia dekades klp

units = initial_number % 10
tens = (initial_number % 100) // 10
thousands = (initial_number % 1000) // 100

print('Digit 1: ', thousands)
print('Digit 2: ', tens)
print("Digit 3: ", units)

sum = units + tens + thousands
print("Sum of the digits: ", sum)

reversed_num = units * 100 + tens * 10 + thousands
print("Reversed number is: ", reversed_num)