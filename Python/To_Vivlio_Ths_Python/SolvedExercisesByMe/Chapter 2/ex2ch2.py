"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

poso = float(input('Give the total value: '))

doseis = int(input('Give the total amount of installments: '))

poso_kathe_dosis = poso / doseis
print('Installment value: ', poso_kathe_dosis)

poso_kathe_dosis = (poso / doseis) * 1.07
#poso_kathe_dosis= (poso/doseis) + (poso/doseis)*0.07
print('Installment value with 7% interest rate in the installment value: ', poso_kathe_dosis)
