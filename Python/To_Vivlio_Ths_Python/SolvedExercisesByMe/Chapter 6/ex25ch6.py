"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

password = 'D3\\/' 

foundNum = foundCapital = foundSymbol = foundRightLength = False

if len(password) >= 8:
    foundRightLength = True

for char in password:
    if char.isupper():
        foundCapital = True
    if char.isdigit():
        foundNum = True
    if not char.isdigit() and not char.isalpha(): #sumbol
        foundSymbol = True
    
    if foundSymbol and foundRightLength and foundNum and foundCapital:
        print('Strong password.')
        break
if not foundCapital or not foundNum or not foundRightLength or not foundSymbol:
    print('Not a strong password.')