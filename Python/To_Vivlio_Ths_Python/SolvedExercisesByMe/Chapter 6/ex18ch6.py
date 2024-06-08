"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

number = input('Please enter a number in the range (0, 1) and not something like .xxx99: ')

#suppose the round will happen in the last digit after the . in the final number (2 digit precision)
if len(number) == 3: #for example 0.1 
    number = number[2:]
    newNum = number + '0' + '.' + '0' + '0' # for example 0.1 -> 10.00%
elif len(number) == 4: # for example 0.11 or 0.56 
    number = number[2:]
    newNum = number + ',' + '0' + '0' # for example 0.11 -> 11.00%
elif len(number) == 5: # for example 0.111 or 0.459-> 45,90 
    number = number[2:]
    newNum = number[:2] + '.' + number[2:] + '0' # for example 0.111 -> 11.10%
elif len(number) >= 6: #for example 0.1111
    number = number[2:] # the number has the format 0.xxxxx so position 0 is 0, position 1 is . and position 2 and so on is the remaining number
    newNum = number[:2] + ',' + number[2:4] #[:2] means from the beginning until 2 forward but not containing the 2 position. Watch the : in order to understand which is the start and which is the end
                                            #I use [:2] to take the first 2 digits of the 0.xxxx but those who are after the .
                                            #After i used the [2:4] to take another 2 digits like i multiplied the 0.xxxx by 100 and took the 2 digits after the .
    if newNum[-1] >= '5':
        newChar = ord(newNum[-2]) + 1
        newNum = newNum[:-2] + chr(newChar) + '0' #last digit >= 5 then it becomes 0 and the previous one increases by 1
#suppose the user does not insert something like .99 because its gonna ruin everything
print(f'{newNum}%')  