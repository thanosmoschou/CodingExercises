"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter a message: ")

#Meta apo kathe characthra tou reversed(message) tha kollaei ton charaktira(or to keimeno) anamesa sta quotes me to opoio klithike h methodos(edo den tha kollaei tipota)
#Dhl an po 'Geia'.join('Hello') tha ginei: HGeiaeGeialGeialGeiaoGeia
if(message == ''.join(reversed(message))): 
    print("The message is palindrome.")
else:
    print("The message is not palindrome.")

#Enalllaktiki lysi
if(message == message[::-1]): #slicing
    print("The message is palindrome.")
else:
    print("The message is not palindrome.")
