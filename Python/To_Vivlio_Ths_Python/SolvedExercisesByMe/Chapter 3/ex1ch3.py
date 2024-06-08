"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

print('H vathmologisi tou ypopsifiou ginetai se klimaka 0...100')
vathmos1 = float(input('Dwse ton 1o vathmo: '))
vathmos2 = float(input('Dwse ton 2o vathmo: '))
vathmos3 = float(input('Dwse ton 3o vathmo: '))

mo = (vathmos1 + vathmos2 + vathmos3) / 3

if(vathmos1 >= 50 and vathmos2 >= 50 and vathmos3 >= 50) or mo >= 75:
    print("O ypopsifios petyxe!")
else:
    print("Dustyxws o ypopsifios den petyxe...")

