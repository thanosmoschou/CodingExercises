"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

ores_ergasias = int(input('Give the weekly working hours: '))
payment_per_hour = float(input('Give the payment per hour: '))
kids = int(input('Give the number of your kids: '))

epidoma = 20 * kids

arx_poso = ores_ergasias * payment_per_hour
kratiseis_asf = arx_poso * 0.1
kratiseis_for = arx_poso * 0.12

tel_poso = arx_poso - kratiseis_asf - kratiseis_for + epidoma

print("Security deduction: ", kratiseis_asf)
print("Tax deduction: ", kratiseis_for)
print("Kids allowance: ", epidoma)
print("Total payment value per week: ", tel_poso)