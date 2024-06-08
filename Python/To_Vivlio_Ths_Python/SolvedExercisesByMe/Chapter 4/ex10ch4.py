"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

beans = int(input('Dwse ton arithmo fasoliwn gia to paixnidi: '))
contin = True
gamesPlayed = wins = 0

while beans > 0 and contin:
    
    while True:
        bet = int(input('Dwse poso pontarismatos: '))
        if bet > beans:
            print('Den exeis tosa fasolia.')
        else:
            break
    
    die1 = randint(1,6)
    die2 = randint(1,6)
    print('Die1: ', die1, 'Die2: ', die2)

    gamesPlayed += 1
    if (die1 == 6 and die2 == 6) or (die1 == 5 and die2 == 5) or (die1 == 2 and die2 == 2) or (die1 == 3 and die2 == 3)\
        or (die1 == 6 and die2 == 5) or (die1 == 5 and die2 == 6):
        print('Kerdises! ')
        beans += bet
        wins += 1
    elif (die1 == 1 and die2 == 1) or (die1 == 2 and die2 == 2) or (die1 == 4 and die2 == 4) or (die1 == 1 and die2 == 2)\
        or (die1 == 2 and die2 == 1):
        print('Exases...')
        beans -= bet
    else:
        print('Ksanapaizeis')
    
    decision = int(input('8es na ksanapaikseis(0/1)? '))
    if not decision:
        contin = False
        
else:
    if contin: #an einai true tote exoun teleiosei ta fasolia
        print('Den exeis fasolia..')

print('Enapomeinanta fasolia: ', beans, 'Kerdismena paixnidia: ', wins, 'Synolika paixnidia: ', gamesPlayed)