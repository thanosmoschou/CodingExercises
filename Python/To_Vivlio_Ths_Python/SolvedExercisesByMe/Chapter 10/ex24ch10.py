"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def func(num):
    palind = True
    numList = []

    while True: #spao ton arithmo mou kai vazo ta psifia se lista
        if num % 10 == 0 and num // 10 == 0:
            break
        else:
            numList.append(num % 10)
            num = num // 10
    
    for i in range(len(numList) // 2):
        if numList[i] != numList[len(numList) - 1 - i]:
            palind = False
            break
    
    return palind


def main():
    num = int(input('Please enter a number(more than 3 digits): '))
    print('This number is', ['not palindrome', 'palindrome'][func(num)])


if __name__ == '__main__':
    main()