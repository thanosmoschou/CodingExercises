"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

class ElemList:
    def __init__(self, list1):
        self.list = list(list1)

    def tomi(self, other):
        intersec = set()
        for item in self.list:
            for item2 in other.list:
                if item == item2:
                    intersec.add(item2)
                    find = True
                    break
        return f'H tomi ton liston {self.list} kai {other.list} einai to sinolo {intersec}'

    def enosi(self, other):
        uni = set()
        for item in self.list:
            uni.add(item)
        for item in other.list:
            uni.add(item)
        
        return f'H enosi ton liston {self.list} kai {other.list} einai to sunolo {uni}'

list1 = ElemList([randint(0, 10) for item in range(4)])
list2 = ElemList([randint(0, 10) for item in range(4)])

print(list1.enosi(list2), list2.enosi(list1), list1.tomi(list2), list2.tomi(list1), sep = '\n')