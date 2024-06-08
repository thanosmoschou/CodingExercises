"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = (1, 4, 5, 0, 12, 45, 67, 89, 10, 11)

tup1Sep = ()
tup2Sep = ()
for i in range(len(tup) // 2):
    tup1Sep += (tup[i]), #gia na antimetopistei os tupple me 1 mono timi. An evaza mono (tup[i]) tha antimetopizotan os 1 timi. Mporo kai tup[i], anti gia (tup[i]), .To idio kai sto kato
    tup2Sep += (tup[(len(tup) // 2) + i]), 

tup1Sep = sorted(tup1Sep, reverse = True)
tup2Sep = sorted(tup2Sep)

tup = (tup1Sep, tup2Sep)
print(tup)