"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

player1 = float(input('Player1 insert the money you gave: '))
player2 = float(input('Player2 insert the money you gave: '))
player3 = float(input('Player3 insert the money you gave: '))
total_played = player1 + player2 + player3

#Afou diavaso ta posa, vrisko to sunoliko kai to pososto tou kathe paixti se auto me vasi oti edosan
#Meta pairno to poso pou kerdisan kai me vasi to pososto sto arxiko poso pairnoun to meridio sto kerdoforo

perc1 = player1 / total_played 
perc2 = player2 / total_played 
perc3 = player3 / total_played 


total_won = float(input('Give the winning value: '))

player1 = total_won * perc1
player2 = total_won * perc2
player3 = total_won * perc3

print('Player1 deserves: ', player1, 'Player2 deserves: ', player2, 'Player3 deserves: ', player3)

