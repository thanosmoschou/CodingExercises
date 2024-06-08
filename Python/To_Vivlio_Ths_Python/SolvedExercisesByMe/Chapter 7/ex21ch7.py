"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

username = "Thanos Moschou"
password = "Msco Thonas"

tup = (username, password)
halfDiff = False
ctrDiff = 0

for i in range(len(tup[0])):
    same = False
    for j in range(len(tup[1])):
        if tup[0][i] == tup[1][j]:
            same = True
            break #vrika omoio ara proxorao ston epomeno xarakthra tou username
    
    if not same:
        ctrDiff += 1 

if ctrDiff >= len(tup[0]) // 2: #kata to imisi diaforetikoi theoro oti toulaxiston oi misoi xaraktires tou username einai diaforetikoi apo tous charactires tou password
   print("Username and Password are half different")
else:
    print("Username and password are not half different")