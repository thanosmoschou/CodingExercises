"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

products = {} #xrisimopoio leksiko giati to onoma tha to paro os kleidi kai an den epairna leksiko tha eixa pollous elegxous px se lista an uparxei to onoma na prostheso to proion allios na to prostheso to onoma
#stin lista kai na valo kai tin posotita. Ara glitono elegxous

with open("ex6ch12.dat", "r") as file:
    line = file.readline()

    orders = 0
    total = 0
    while line:
        if products.get(line[0], 0) != 0:
            orders += 1
            total += int(line[3:-1]) #gia na mhn valo to \n. Pote den ftanei sto end dhl tha paei mexri -2 apo to telos
            products[line[0]] = (orders, total)        
        else:
            orders = 1
            total = int(line[3:-1])
            products[line[0]] = (orders, total)

        line = file.readline()


with open("ex6ch12ResProd.dat", "w") as writeFile:
    for key, value in products.items():
        writeFile.write(key)
        writeFile.write(',')
        writeFile.write(str(value[0]))
        writeFile.write(',')
        writeFile.write(str(value[1]))
        writeFile.write('\n')