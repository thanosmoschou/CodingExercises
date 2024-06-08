"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from math import ceil


bill = float(input('Give your total bill: '))
money_given = float(input("Give the money you gave: "))

fpa = bill * 0.24
print("Value added tax:", fpa)

bill += fpa
print("Total value:", bill)

change = money_given - bill
print("Change:", change)

coupons = bill / 25
print("Total coupons you deserve with every 25 Euro bill:", coupons)