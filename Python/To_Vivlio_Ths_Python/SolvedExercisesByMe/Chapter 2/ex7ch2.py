"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from math import ceil


in_price = float(input("Insert the value of the product: "))
in_pay = float(input("Insert the payment value: "))

#price, pay = in_price, in_pay
in_change = (in_pay - in_price)
change = in_change

two_euro = change // 2 #Div gia na dothei timi kai sta mikroteris axias kermata allios tha ginei dekadiki diairesi kai sta alla tha antoistoixei timi 0
change -= (2 * two_euro) #Afairo to antoistoixo poso gia ta 2 euro 
one_euro = change // 1 #Min sou fainetai autonoito thelo akeraio poso kermaton
change -= one_euro
half_euro = change // 0.5
change -= 0.5 * half_euro
zero_point_one = change * 100  # gia na to kano arithmo megalitero tis monadas

print("Change: ", in_change)
print("2 Euro: ", int(two_euro))
print("1 Euro: ", int(one_euro))
print("0.5 Euro: ", int(half_euro))
print("0.1 Euro: ", int(zero_point_one))


