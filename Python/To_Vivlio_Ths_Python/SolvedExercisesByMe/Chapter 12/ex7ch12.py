"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

with open("ex7ch12Data.dat", 'r') as file:
    user = input('Please enter your username here: ')
    line = file.readline()
    found = True

    while line:
        if line[:-1] == user: #den thelo to \n
            print(f'{user} is already in the system!')
            break
        else:
            line = file.readline()
    else: #epistrefei '' to opoio einai to EOF sthn python. Mpainoume sto else an stamatisei i while apo condition kai oxi apo break
        found = False

    #if line == '' to alternative gia to else

if not found:
    with open("ex7ch12Data.dat", 'a') as file:
        print(f'New user in the system: {user}!')
        file.write(user)
        file.write('\n')