"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

temperature = float(input("Give the current temperature in Celcius: "))

Fahrenheit = 9/5 * temperature + 32
Kelvin = temperature + 273.15
Rankive = temperature + 9/5 * 273.15
Delisle = 3/2 * (100 - temperature)
Newton = temperature - 33/100
Reamur = 4/5 * temperature
Romer = 21/40 * temperature + 7.5

print("Fahrenheit: ", Fahrenheit)
print("Kelvin: ", Kelvin)
print("Rankive: ", Rankive)
print("Delisle: ", Delisle)
print("Newton: ", Newton)
print("Reamur: ", Reamur)
print("Romer: ", Romer)