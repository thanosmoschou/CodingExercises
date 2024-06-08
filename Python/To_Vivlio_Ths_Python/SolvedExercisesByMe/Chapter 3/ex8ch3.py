"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

A = 0.2
B = 0.4

clothA = float(input("Dwse metra gia to yfasma A: "))
clothB = float(input("Dwse metra gia to yfasma B: "))

sum = (A * clothA) + (B * clothB)

if sum <= 100 or (clothA + clothB) <= 300: #false mono an kai ta duo vgoun false dil sum > 100 kai to allo >300 
    sum -= (0.05 * sum)
else:
    sum -= (0.15 * sum)

print("Pliroteo poso: ", sum)