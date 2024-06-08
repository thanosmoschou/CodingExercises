"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

succeed = succMinTry = 0
minTries = 6 #max tries to catch the limit so i want to get lower than that

athletes = int(input('Dwse synoliko arithmo athlitwn: '))
for i in range(athletes):
    ctr = 1
    name = input('Dwse onomateponymo: ')
    for j in range(6):      
        tries = float(input('Dwse thn prospatheia: '))
        if tries >= 5.3:
            print(name, 'Prokrinetai!')
            succeed += 1         
            if ctr < minTries:
                succMinTry = 1
                minTries = ctr
            elif ctr ==  minTries:
                succMinTry += 1
            
            break
        else:
            ctr += 1
    if ctr > 6:
        print(name, 'Den prokrinetai...')


print('Synolo epityxontwn: ', succeed, 'Ligoteres prospatheies gia prokrish: ', minTries, 'Synolo epityxontwn me tis ligoteres prospatheies: ', succMinTry)