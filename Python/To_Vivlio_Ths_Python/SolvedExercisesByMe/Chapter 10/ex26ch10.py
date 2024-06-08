"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint as rnd

def checkIfPerfect(num):
    divList = []

    for item in range(1, (num // 2) + 1): #oi diairetes enos arithou einai panta mexri arithmos // 2
        if num % item == 0: #vrisko tous diairetes kai tous vazo se lista
            divList.append(item)

    print(f'Oi diairetes tou {num} einai: {divList}')
    return num == sum(divList) #Epistrefei True h False kathos enas arithmos einai teleios an to athroisma 
                               #ton thetikon diaireton xoris ton idio ton arithmo na isoutai me ton idio ton arithmo

def main():
    num1 = rnd(1, 8) #random number me euros apo 1 os 8
    #to ['is not perfect', 'is perfect'][checkIfPerfect(num1)] einai san na exo lista 
    #list = ['is not perfect', 'is perfect'] kai meta na leo
    #list[kati] opou kati tha einai eite 0 eite 1 giati i sinartisi tha girisei true h false
    print('Number', num1, ['is not perfect', 'is perfect'][checkIfPerfect(num1)])
    return

if __name__ == '__main__':
    main()