"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter your message here: ")

dict1 = {}

for char in message:
    if char != ' ':
        dict1[char] = dict1.get(char, 0) + 1 #an den uparxei to kleidi epistrefetai 0 kai dimiourgeitai nea kataxorisi
                                             #me timi 0 h opoia auksanetai. An uparxei to kleidi epistrefetai
                                             #h timi tou kleidiou thn opoia auksano kata 1
print(dict1)