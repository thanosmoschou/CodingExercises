"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

with open('ex8ch12File1.dat', 'r') as file1: #pairno ta arxika emails apo to file 1
    list1 = []
    line = file1.readline()

    while line:
        list1.append(line[: -1]) #den thelo to \n
        line = file1.readline()

with open('ex8ch12File2.dat', 'r') as file2: #pairno ta username apo to file 2
    list2 = []
    line = file2.readline()

    while line:
        list2.append(line[: -1]) #den thelo \n
        line = file2.readline()

with open('ex8ch12File3.dat', 'r') as file3: #pairno ta tmimata apo to file 3
    list3 = []
    line = file3.readline()

    while line:
        list3.append(line[: -1]) #den thelo to \n apo kathe tmima
        line = file3.readline()

#create new emails
list4 = []
for i in range(len(list1)): #oles oi listes to idio megethos exoun
    email = list2[i] + '@' + list3[i] + '.' + 'ThanosLabs.com' #companny name = ThanosLabs
    list4.append(email)

#vazo se neo arxeio to iparxon email tou kathena kai sthn idia grammi to neo pou eftiaksa
with open('ex8ch12Out.dat', 'w') as file4:
    for i in range(len(list4)):
        file4.write(list1[i])
        file4.write('    ')
        file4.write(list4[i])
        file4.write('\n')