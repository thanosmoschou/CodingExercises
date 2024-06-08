"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = ((2, 4), (4, 6, 8), (5, 6, 8), (9, 0))
ctr = 0

for item in range(len(tup)): #deiktis sto kathe stoixeio ths pleiadas panta se 1o epipedo dhl oxi gia oti periexoun esoterika ta antikeimena ths pleiadas
    for item2 in range(len(tup[item])): #gia kathe stoixeio ths pleiadas thelo to plithos ton antikeimenon tou
        ctr += 1

print(ctr)