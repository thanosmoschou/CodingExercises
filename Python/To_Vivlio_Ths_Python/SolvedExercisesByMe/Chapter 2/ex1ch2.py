"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

arx_poso = float(input('Give the initial price: '))
posost_ekpt = float(input('Give the percentage of discount: '))

posost_ekpt = posost_ekpt / 100
poso_ekpt = arx_poso * posost_ekpt
tel_poso = arx_poso - poso_ekpt

print('Discount:', poso_ekpt)
print('Final price:', tel_poso)

