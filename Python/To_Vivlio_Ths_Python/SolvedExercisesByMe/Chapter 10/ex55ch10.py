"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def getFact(num):
    f = 1
    for i in range(1, num + 1):
        f *= i
    
    return f

def findE(lim):
    e = 0
    for i in range(1, lim + 1): #gia na pao os to lim
        e += 1/getFact(i)
    
    return e

def main():
    while True:
        lim = int(input('Please enter the limit for E constant calculation: '))
        if lim <= 0:
            print('Invalid Data...Only numbers greater than 0 are valid')
        else:
            break

    print(f'E = {findE(lim)}')
    return 0

if __name__ == '__main__':
    main()