"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

p = 3.14
perimeter = float(input("Enter the perimeter of a cirle: "))

#perimeter = 2*p*r : p = 3.14, r is the radius
#diameter = 2 * r

radius = perimeter / (2 * p)
diameter = 2 * radius
print("Diameter: ", diameter)