"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

def main():
    list1 = [randint(1, 10) for i in range(10)]
    s = lambda list1: sum([item for item in list1 if item % 2 == 0])
    print(f'Sum of even numbers of list: {list1} is: {s(list1)}')

if __name__ == '__main__':
    main()