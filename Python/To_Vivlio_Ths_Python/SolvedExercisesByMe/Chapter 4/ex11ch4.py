"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

NPV = 0
C0 = 100000
r = 0.05
T = 5
years = int(input('Dwse ta xronia gia ta opoia epithimeis na kaneis mia ependisi: '))
i = 1

while i <= years:
    Ct = int(input('Dwse thn tameiaki roh: '))
    NPV += ((Ct / (1 - r) ** i) - C0)
    i += 1

if NPV > 0:
    print('H protash einai elkistiki!')
else:
    print('H protash den einai elkistiki...')
