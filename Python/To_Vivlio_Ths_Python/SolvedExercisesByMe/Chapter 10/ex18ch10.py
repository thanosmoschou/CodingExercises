"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

"""
Den mporo na exo 1 function pou analoga me ton arithmo na katalavainei ti metatropi na kanei.
An px arithmos = 23 ok -> dec to bin
Elegxos gia dec -> bin = an do psifio > 1 ston arithmo mou.
An do omos 1 arithmo opos 1100 ? Den ksero an einai dekadikos h diadikos. Mporo 
men na po oti tha metatrepo dec to bin efoson xorane se 1 byte dhl einai < 256. Ara px an do 110 < 256 ara 
to kano dec to bin. Einai omos dec? Den kseroume. Oute mporo na kano kai tis 2 metatropes gt den ksero 
ti sistima antiprosopeuei.
"""

def binToDec(num):
    sum = 0
    ctrPos = 0
    num = str(num) #to take every single digit of my binary number. Then transform it to integer again
    for item in num[::-1]:
        #1101 = 1*2^0 + 0*2^1 + 1*2^2 + 1*2^3 = 13
        sum += int(item) * (2 ** ctrPos)
        ctrPos += 1
    
    return sum 

"""
Diairoume diadoxika me to 2 kratame to upoloipo kai shmeionoume to piliko.
Diairoume to neo piliko me 2 kratame to upoloipo kai shmeionoume to piliko.
To idio mexri to piliko na ginei 0 opou kai tha paro to teleutaio upoloipo.
Tora o arithmos mou einai ta upoloipa apo to pio prosfato pros to paliotero.
px 23 // 2 = 12 upoloipo 1
   12 // 2 = 6 upoloipo 0
   6 // 2 = 3 upoloipo 0
   3 // 2 = 1 upoloipo 1
   1 // 2 = 0 upoloipo 1
   Ara 11001
"""

def decToBin(num):
    binNum = []
    while num // 2 != 0:
        binNum.append(num % 2)
        num = num // 2
    else: #an h while stamathsei apo tin sinthiki tis. Otan exo break sthn while loop tote an kanei break den mpainei sto else
        binNum.append(num % 2)
    
    return binNum[::-1] #anapoda an paro ta upoloipa einai o arithmos mou

print(binToDec(1100), decToBin(2), sep = '\n')
#23 = 10111