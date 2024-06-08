"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

minutes = int(input("Please insert the total minutes that you talked this month: "))
sms = int(input("Enter the total sms messages for this month: "))

sum = 0
pagio = 5

if minutes <= 60:
    sum += (minutes * 0.03)
elif minutes <= 120:
    sum += (minutes * 0.025)
else:
    sum += (minutes * 0.018)

if sms <= 100:
    sum += (sms * 5)
elif sms <= 200:
    sms += (sms * 10)
else:
    sum += (sms * 15)

sum += pagio
sum += 0.24 * sum

print("Total charge : ", sum)