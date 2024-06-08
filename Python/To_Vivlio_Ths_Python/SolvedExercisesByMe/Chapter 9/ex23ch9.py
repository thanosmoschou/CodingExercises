"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

dict1 = {}

for i in range(10): #tuxaia kleidia kai tyxaies times alla ta 2 leksika exoun ta idia kleidia
    dict1[randint(0, 5)] = randint(0, 10)

dict2 = {}
for i, value1 in dict1.items(): #tora thelo oi times tou dict1 na ginoun kleidia kai osa kleidia tou dict1 exoun idia timi
                                #ayta ta kleidia tha ta valo se tuple sto dict2 me kleidi thn timi tou dict1
    dict2[value1] = (i),        #to kleidi ginetai timi kai h timi kleidi
    for j in dict1.keys():      #gia ola ta kleidia tou dict1 thelo ekeina pou exoun idia timi
        if dict1[j] == dict1[i] and i != j: #gia na min valo tin arxiki timi (to kleidi tou dict1) 2 fores os timi sto dict2(sthn tuple)
            dict2[value1] += j,

print(dict1)
print(dict2)