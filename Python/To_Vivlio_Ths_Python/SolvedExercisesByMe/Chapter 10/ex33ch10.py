"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#mkd me algorithmo tou euklidi
#gcd(a, b) = gcd(b, r) opou r =  a mod b
# gcd(100, 35) = gcd(35, 100 mod 35) = gcd(35, 30)
# = gcd(30, 35 mod 30) = gcd(30, 5)
# = gcd(5, 30 mod 5) = gcd(5, 0)
# = 5

from random import randint

def findMKD(num1, num2):
    if num2 == 0:
        return num1
    else:
        temp = num2 #sozo to b
        num2 = num1 % num2 #vrisko to neo b vasei a mod b
        num1 = temp #dino sto a to palio b
        return findMKD(num1, num2) 

def main():
    num1, num2 = [100, 30]
    print(f'MKD ton {num1} kai {num2} = {findMKD(num1, num2)}')
    return

if __name__ == '__main__':
    main()