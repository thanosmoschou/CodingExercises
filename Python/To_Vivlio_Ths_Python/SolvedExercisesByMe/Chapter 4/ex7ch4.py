"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

ypopsifioi = int(input("Dwse synoliko arithmo ypopsifiwn: "))
sumTest = int(input("Dwse synoliko arithmo test gia thn eksetash: "))
sumEpit = sumEpitVath = 0

for i in range(1, ypopsifioi + 1): 
    onomatepwnymo = input("Dwse onomatepwnymo: ")
    sumvathm = 0
    
    for j in range(1, sumTest + 1):
        test = float(input("Dwse vathmo tou test:"))
        sumvathm += test
    
    mo = (sumvathm / sumTest) 
    if mo > 80:
        sumEpit += 1
        sumEpitVath += mo
        print("Epityxwn: ", onomatepwnymo, "Mesh vathmologia: ", mo, "%")

if sumEpit == 0:
    print("Dystyxws den yphrxan epityxontes...")
else:
    print("Synolo epityxontwn: ", sumEpit, "MO Epityxontwn: ", (sumEpitVath / sumEpit), "%") 
