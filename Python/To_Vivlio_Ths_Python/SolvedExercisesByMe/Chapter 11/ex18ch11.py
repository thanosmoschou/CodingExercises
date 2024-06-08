"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint
  
words = ['aeroplane', 'balloon', 'basketball', 'football', 'hamburger', 'universe', 'australia', 'tennis',
        'treasure', 'hotspot']

def messagePrompt():
    print('Welcome to the game. You have to find the word.')

class FindWordGame:
    def __init__(self):
        self.initialWord = words[randint(0, len(words) - 1)] #select word from the initial word list
        self.initialWord = list(self.initialWord) #spao tin leksi se grammata
        self.showWord = list('-' for i in range(len(self.initialWord))) #emfanisi ------------
        self.showWord[0] = self.initialWord[0] #vazo to arxiko k to teleutaio gramma
        self.showWord[len(self.initialWord) - 1] = self.initialWord[len(self.initialWord) - 1]
        self.letterAttempts = 8
        self.notIncludedInWord = list()

    def findLetter(self, letter):
        found = False
        for ctr, item in enumerate(self.initialWord):
            if item == letter: #reveal all the common letters
                found = True
                for i in range(ctr, len(self.initialWord)): #psaxno na vro tis theseis pou uparxei to gramma
                    if self.initialWord[i] == item and self.showWord[i] == '-': #na mhn ksanavalo to idio gramma stin idia thesi
                        self.showWord[ctr] = item #gia na eimai entos index
        
        if not found: #den uparxei to gramma
            for let in self.notIncludedInWord:
                if let == letter:
                    break
            else:
                self.letterAttempts -= 1
                self.notIncludedInWord.append(letter) #put the letter in the blacklist
            
            print(f'You have {self.letterAttempts} remaining.')
            print(f'Letters not included in the word: {self.notIncludedInWord}')


messagePrompt()
w = FindWordGame()

while w.letterAttempts:
    print(w.showWord)
    letter = input('Enter the letter: ')
    #letter = letter[:-1]
    w.findLetter(letter)
    
    for item in w.showWord:
        if item == '-': #exei grammata akoma na apokalifthoun
            break
    else:
        print(f'{w.showWord}\nCongrats!!!You found all the letters!!!')
        break
else:
    print(f'You lose...\nThe word is {w.initialWord}')