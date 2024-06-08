"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

typeList = []
salesList = []

for i in range(10):
    typeList.append(randint(1, 3))
    salesList.append(randint(0, 20))

print('Types: ', typeList, '\nSales: ', salesList)

sumType = [0] * 3
for i in range(10):
    sumType[typeList[i] - 1] += salesList[i]

for i in range(1, 4):
    print('Total sales of type ', i, ': ', sumType[i - 1])

minProd = min(salesList)
indexOfMin = salesList.index(minProd) #only for the first seen value
typeMin = typeList[indexOfMin]
print('Less sold product: ', minProd, 'with product type: ', typeMin)

type1Sales = [salesList[i] for i in range(10) if typeList[i] == 1]
type2Sales = [salesList[i] for i in range(10) if typeList[i] == 2]
type3Sales = [salesList[i] for i in range(10) if typeList[i] == 3]

type1Sales.sort(reverse = True)
print('Type 1 sales in descending order: ', type1Sales)

type2Sales.sort(reverse = True)
print('Type 2 sales in descending order: ', type2Sales)

type3Sales.sort(reverse = True)
print('Type 3 sales in descending order: ', type3Sales)

typeWithMost0Sales = 0
count1Sales = count2Sales = count3Sales = 0

for i in range(len(salesList)):
    if salesList[i] == 0:
        if typeList[i] == 1:
            count1Sales += 1
        elif typeList[i] == 2:
            count2Sales += 1
        else:
            count3Sales += 1

if count1Sales > count2Sales and count1Sales > count3Sales:
    typeWithMost0Sales = 1
elif count2Sales > count3Sales:
    typeWithMost0Sales = 2
else:
    typeWithMost0Sales = 3

if count1Sales == count2Sales == count3Sales == 0:
    print('No type with 0 sales...')
else:
    print('Product type with most 0 sales: ', typeWithMost0Sales)