"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

consumption_100 = float(input("Dwse tin katanalosi ana 100km: "))
distance_trip = float(input("Dwse tin apostasi pou tha dianuseis: "))

fuel = (consumption_100 / 100) * distance_trip  

print("Tha xreiasteis: ", fuel, "litra venzinis")