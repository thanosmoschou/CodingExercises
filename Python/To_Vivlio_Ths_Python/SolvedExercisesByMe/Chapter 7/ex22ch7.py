"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

import collections

student = collections.namedtuple('Student', 'Name Grade Class')
carlos = student(Name = 'Carlos', Grade = 10, Class = 'A')
barbara = student(Name = 'Barbara', Class = 'B', Grade = 8)
anastacia = student(Class = 'D', Name = 'Anastacia', Grade = 7)

list = [carlos, barbara, anastacia]
list = sorted(list, key = lambda student: student.Grade, reverse = True)
print(list)

list.sort(key = lambda student: student.Grade)
print(list)