"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

#user has X, cpu has O
class Board:
    def __init__(self):
        self.boardTic = list([['-', '-', '-'], ['-', '-', '-'], ['-', '-', '-']])
        self.userWin = False
        self.cpuWin = False

    def playUser(self):
        while True: #tha afaireso 1 gt o xristis ksekinaei apo to 1 kai oxi apo to 0
            loc1, loc2 = input('Please enter the place that you want to put the letter(for example for place 2,3 \
enter 2 3:  ').split() #pairno to string kai to kano split kai unpack
            loc1, loc2 = int(loc1), int(loc2)
            if (loc1 - 1 < 0 or loc1 - 1 > 2) or (loc2 - 1 < 0 or loc2 - 1 > 2): #limit check
                print('Invalid position...Try again')
            else: #place check
                if self.boardTic[loc1 - 1][loc2 - 1] != '-':
                    print('Invalid position...Try again')
                else:
                    self.boardTic[loc1 - 1][loc2 - 1] = 'X'
                    break
        
    
    def playCpu(self):
        while True:
            loc1, loc2 = [randint(0, 2) for i in range(2)]
            if self.boardTic[loc1][loc2] != '-':
                pass #repeat the loop...invalid position
            else:
                self.boardTic[loc1][loc2] = 'O'
                break
    
    def checkWin(self):
        if self.boardTic[0][0] == self.boardTic[0][1] and self.boardTic[0][1] == self.boardTic[0][2]: #just like maths...if a==b and b==c then a==c so i do not have to compare
            if self.boardTic[0][0] == 'X': 
                self.userWin = True
            elif self.boardTic[0][0] == 'O':
                self.cpuWin = True
        elif self.boardTic[1][0] == self.boardTic[1][1] and self.boardTic[1][1] == self.boardTic[1][2]:
            if self.boardTic[1][0] == 'X': 
                self.userWin = True
            elif self.boardTic[1][0] == 'O':
                self.cpuWin = True
        elif self.boardTic[2][0] == self.boardTic[2][1] and self.boardTic[2][1] == self.boardTic[2][2]:
            if self.boardTic[2][0] == 'X': 
                self.userWin = True
            elif self.boardTic[2][0] == 'O':
                self.cpuWin = True
        elif self.boardTic[0][0] == self.boardTic[1][0] and self.boardTic[1][0] == self.boardTic[2][0]:
            if self.boardTic[0][0] == 'X': 
                self.userWin = True
            elif self.boardTic[0][0] == 'O': 
                self.cpuWin = True
        elif self.boardTic[0][1] == self.boardTic[1][1] and self.boardTic[1][1] == self.boardTic[2][1]:
            if self.boardTic[0][1] == 'X': 
                self.userWin = True
            elif self.boardTic[0][1] == 'O':
                self.cpuWin = True
        elif self.boardTic[0][2] == self.boardTic[1][2] and self.boardTic[1][2] == self.boardTic[2][2]:
            if self.boardTic[0][2] == 'X': 
                self.userWin = True
            elif self.boardTic[0][2] == 'O': 
                self.cpuWin = True
        elif self.boardTic[0][0] == self.boardTic[1][1] and self.boardTic[1][1] == self.boardTic[2][2]:
            if self.boardTic[0][0] == 'X': 
                self.userWin = True
            elif self.boardTic[0][0] == 'O': 
                self.cpuWin = True
        elif self.boardTic[0][2] == self.boardTic[1][1] and self.boardTic[1][1] == self.boardTic[2][0]:
            if self.boardTic[0][2] == 'X': 
                self.userWin = True
            elif self.boardTic[0][2] == 'O': 
                self.cpuWin = True

    def viewFull(self):
        self.full = True
        for item in self.boardTic:
            for item2 in item:
                if item2 == '-':
                    self.full = False #exei theseis akoma gia grammata
                    break
            
            if not self.full:
                break
            
    def showTable(self):
        for item in self.boardTic:
            print(f'{item[0]}|{item[1]}|{item[2]}\n')
        print('\n')

ticTacToe = Board()
ticTacToe.showTable() #print the table
while True:
    #user turn
    ticTacToe.viewFull() #kano diplous elegxous alla den glitonetai gia thn ora
    if ticTacToe.full:
        print('Tie...')
        break
    ticTacToe.playUser() #enter the location
    ticTacToe.showTable()
    ticTacToe.checkWin() #check win
    if ticTacToe.userWin:
        print('User Wins!!!')
        break
    elif ticTacToe.cpuWin:
        print('CPU Wins...')
        break

    #cpu turn
    #ticTacToe.showTable()
    ticTacToe.viewFull()
    if ticTacToe.full:
        print('Tie...')
        break
    ticTacToe.playCpu()
    ticTacToe.showTable()
    ticTacToe.checkWin()
    if ticTacToe.userWin:
        print('User Wins!!!')
        break
    elif ticTacToe.cpuWin:
        print('CPU Wins...')
        break