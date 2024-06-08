"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint as rnd

def main():
    list1 = [rnd(-10, 10) for i in range(10)]
    filterList = lambda list1: [item for item in list1 if item > 0]
    print('Initial list: ', list1, 'Filtered list: ', filterList(list1), sep = '\n')
    return

if __name__ == '__main__':
    main()