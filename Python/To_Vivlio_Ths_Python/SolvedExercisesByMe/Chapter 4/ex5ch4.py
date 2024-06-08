"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

conteiner = sumWeight = 0
while 1:
    weight = eval(input('Dwse varos: '))
    if weight > 0:
        break
    else:
        print("Dwse varos thetiko")

while weight + sumWeight <= 10000:
    sumWeight += weight
    if weight > 0:
        conteiner += 1
    if sumWeight == 10000:
        break
    
    while 1:
        weight = eval(input('Dwse varos: '))
        if weight > 0:
            break
        else:
            print("Dwse varos thetiko")


mo = sumWeight / conteiner
print('Synolika conteiners: ', conteiner)
print('Synoliko varos: ', sumWeight)
print('Mesos oros varous: ', mo)
print('Anekmetaleuto varos: ', 10000 - sumWeight)