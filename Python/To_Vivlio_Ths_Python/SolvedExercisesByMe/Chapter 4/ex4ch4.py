"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

sum = 0
ctr = 0
while 1:
    while 1:
        num = eval(input('Dwse arithmo: '))
        if type(num) != int:
            print("lathos typos...dwse akeraio")
        else:
            break
    if num == 0 or ctr > 20: #to ctr > 20 gia logous apofigis mh midenikon arithmon sunexos
        break
    else:
        sum += num
        ctr += 1
if ctr != 0:
    print('MO: ', sum / ctr)
else:
    print('Division by 0')