"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint
from tkinter import N

def func(list1):
    n = 0

    for ctr, item in enumerate(list1):
        n += (10 ** ctr) * item

    return n


def main():
    list1 = [randint(2, 3) for i in range(10)]
    total = func(list1)
    print(total)


if __name__ == '__main__':
    main()