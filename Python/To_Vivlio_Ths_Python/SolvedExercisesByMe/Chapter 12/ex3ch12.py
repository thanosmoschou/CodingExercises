"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

try:
    name = 'ex3ch12.dat'
    filename = open('ex3ch12.dat', 'r')
except FileNotFoundError:
    print(f'Problem with file: {name}')
else:
    data = filename.read() #olo to periexomeno tou arxeiou paei sthn data
    word = []
    word.extend(data) #pairno enan enan tous characters
    insideQuotes = ''
    start = False
    for item in word:
        if item == '"' and not start: #einai to proto quote
            start = True
            continue
        elif item == '"' and start: #einai to deutero quote ara stamatao
            break
            
        if start:
            insideQuotes += item
    
    insideQuotes = insideQuotes + '\0'
    filename.close()
    print(f'Text inside double quotes: {insideQuotes}')