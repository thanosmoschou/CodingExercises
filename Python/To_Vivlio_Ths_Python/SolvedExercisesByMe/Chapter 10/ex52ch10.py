"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import os

def execComm(com):
    #we take the string that describes a command, we compare the string with other strings(that are the commands for execution)
    # and everytime we execute the appropriate command    
    #Note that this program will execute only 3 linux commands
    if com == 'ls':
        print(os.listdir())
    
    if com == 'pwd':
        print(os.getcwd())

    if com == 'cd': #return to user directory
        os.chdir('/home/thanos_mos')
        print(os.getcwd())

    if com != 'ls' and com != 'pwd' and com != 'cd':
        print('Invalid command...')

    return 0

def main():
    comm = input('Please enter a basic linux terminal command here(pwd, ls, cd): ')
    execComm(comm)
    return 0

if __name__ == '__main__':
    main()