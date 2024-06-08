"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

stockBuy1 = []
stockClose1 = []
stockBuy2 = []
stockClose2 = []
stockBuy3 = []
stockClose3 = []
stockBuy4 = []
stockClose4 = []
stockBuy5 = []
stockClose5 = []

#I could insert values by myself but i prefer random values for time saving
daysToCheck = 5
for i in range(daysToCheck):
    stockBuy1.append(randint(100, 1000))
    stockClose1.append(randint(2000, 4000))

    stockBuy2.append(randint(100, 1000))
    stockClose2.append(randint(2000, 4000))

    stockBuy3.append(randint(100, 1000))
    stockClose3.append(randint(2000, 4000))

    stockBuy4.append(randint(100, 1000))
    stockClose4.append(randint(2000, 4000))

    stockBuy5.append(randint(100, 1000))
    stockClose5.append(randint(2000, 4000))

print('Stock 1 Buying Prices:', stockBuy1, '\nClosing Prices:', stockClose1)
print('Stock 2 Buying Prices:', stockBuy2, '\nClosing Prices:', stockClose2)
print('Stock 3 Buying Prices:', stockBuy3, '\nClosing Prices:', stockClose3)
print('Stock 4 Buying Prices:', stockBuy4, '\nClosing Prices:', stockClose4)
print('Stock 5 Buying Prices:', stockBuy5, '\nClosing Prices:', stockClose5)

#Find the total of Stock Profits
totalProfitLastDay = 0
indexLastDay = daysToCheck - 1
for i in range(1, 6):
    if i == 1:
        if stockClose1[indexLastDay] > stockBuy1[indexLastDay]:
            totalProfitLastDay += (stockClose1[indexLastDay] - stockBuy1[indexLastDay])
    elif i == 2:
        if stockClose2[indexLastDay] > stockBuy2[indexLastDay]:
            totalProfitLastDay += (stockClose2[indexLastDay] - stockBuy2[indexLastDay])
    elif i == 3:
        if stockClose3[indexLastDay] > stockBuy3[indexLastDay]:
            totalProfitLastDay += (stockClose3[indexLastDay] - stockBuy3[indexLastDay])
    elif i == 4:
        if stockClose4[indexLastDay] > stockBuy4[indexLastDay]:
            totalProfitLastDay += (stockClose4[indexLastDay] - stockBuy4[indexLastDay])
    elif i == 5:
        if stockClose5[indexLastDay] > stockBuy5[indexLastDay]:
            totalProfitLastDay += (stockClose5[indexLastDay] - stockBuy5[indexLastDay])

print('Total profit of last day: ', totalProfitLastDay)

#Find if there is an improving rate and the average value of every stock
flagImprove = [True] * 5
MO = [0] * 5

for i in range(1, 6):
    if i == 1:
        MO[i -1] += stockClose1[0]
        for j in range(1, daysToCheck):
            if stockClose1[j - 1] >= stockClose1[j]:
                flagImprove[i - 1] = False
                #break
            MO[i -1] += stockClose1[j]
    elif i == 2:
        MO[i -1] += stockClose2[0]
        for j in range(1, daysToCheck):
            if stockClose2[j - 1] >= stockClose2[j]:
                flagImprove[i - 1] = False
                #break
            MO[i - 1] += stockClose2[j]

    elif i == 3:
        MO[i -1] += stockClose3[0]
        for j in range(1, daysToCheck):
            if stockClose3[j - 1] >= stockClose3[j]:
                flagImprove[i - 1] = False
                #break
            MO[i - 1] += stockClose3[j]
    elif i == 4:
        MO[i -1] += stockClose4[0]
        for j in range(1, daysToCheck):
            if stockClose4[j - 1] >= stockClose4[j]:
                flagImprove[i - 1] = False
                #break
            MO[i - 1] += stockClose4[j]
    elif i == 5:
        MO[i -1] += stockClose5[0]
        for j in range(1, daysToCheck):
            if stockClose5[j - 1] >= stockClose5[j]:
                flagImprove[i - 1] = False
                #break
            MO[i - 1] += stockClose5[j]

    MO[i - 1] /= daysToCheck

for i in range(len(flagImprove)):
    if flagImprove[i]:
        print('Stock ', i + 1, 'had increasing value.')
    else:
         print('Stock ', i + 1, 'did not have increasing value.')


#Search for spike days of the stocks
for i in range(1, 6):
    if i == 1:
        for j in range(1, daysToCheck - 1):
            if stockClose1[j - 1] < stockClose1[j] and stockClose1[j] > stockClose1[j + 1]:
                print('Spike Day:', j, 'for Stock No: ', i)
    elif i == 2:
        for j in range(1, daysToCheck - 1):
            if stockClose2[j - 1] < stockClose2[j] and stockClose2[j] > stockClose2[j + 1]:
                print('Spike Day:', j, 'for Stock No: ', 2)
    elif i == 3:
        for j in range(1, daysToCheck - 1):
            if stockClose3[j - 1] < stockClose3[j] and stockClose3[j] > stockClose3[j + 1]:
                print('Spike Day:', j, 'for Stock No: ', 3)
    elif i == 4:
        for j in range(1, daysToCheck - 1):
            if stockClose4[j - 1] < stockClose4[j] and stockClose4[j] > stockClose4[j + 1]:
                print('Spike Day:', j, 'for Stock No: ', 4)
    elif i == 5:
        for j in range(1, daysToCheck - 1):
            if stockClose5[j - 1] < stockClose5[j] and stockClose5[j] > stockClose5[j + 1]:
                print('Spike Day:', j, 'for Stock No: ', i)

for i in range(5):
    print('Stock ', i + 1, 'Average Price: ', MO[i])

typApokl = [0] * 5
diffMinMax = [0] * 5
CV = [0] * 5

#Typiki apoklisi, anoigma kai risko metoxis
for i in range(1, 6):
    S = 0
    if i == 1:
        for j in range(daysToCheck):
            S += (stockClose1[j] - MO[i - 1]) ** 2
        S /= daysToCheck
        typApokl[i - 1] = S ** 0.5
        min1 = min(stockClose1)
        max1 = max(stockClose1)
    elif i == 2:
        for j in range(daysToCheck):
            S += (stockClose2[j] - MO[i - 1]) ** 2
        S /= daysToCheck
        typApokl[i - 1] = S ** 0.5
        min1 = min(stockClose2)
        max1 = max(stockClose2)
    elif i == 3:
        for j in range(daysToCheck):
            S += (stockClose3[j] - MO[i - 1]) ** 2
        S /= daysToCheck
        typApokl[i - 1] = S ** 0.5
        min1 = min(stockClose3)
        max1 = max(stockClose3)
    elif i == 4:
        for j in range(daysToCheck):
            S += (stockClose4[j] - MO[i - 1]) ** 2
        S /= daysToCheck
        typApokl[i - 1] = S ** 0.5
        min1 = min(stockClose4)
        max1 = max(stockClose4)
    elif i == 5:
        for j in range(daysToCheck):
            S += (stockClose5[j] - MO[i - 1]) ** 2
        S /= daysToCheck
        typApokl[i - 1] = S ** 0.5
        min1 = min(stockClose5)
        max1 = max(stockClose5)
    
    diffMinMax[i - 1] = max1 - min1
    CV[i - 1] = diffMinMax[i - 1] / MO[i - 1]

min2 = min(diffMinMax)
min3 = min(CV)

for i in range(daysToCheck):
    print('Typiki apoklisi ths metoxhs: ', i + 1, ': ', typApokl[i])
    if diffMinMax[i] == min2:
        print('Mikrotero anoigma gia thn metoxi: ', i + 1, 'tis timhs: ', min2)
    
    if CV[i] == min3:
        print('Mikrotero risko gia thn metoxi: ', i + 1, 'tis timhs: ', min3)