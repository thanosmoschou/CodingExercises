"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

list1 = [{2:4, 3:6, 4:9}, {4:12, 5:16, 6:19}]
list2 = []

for item in list1: #pairnoume os stoixeio to kathe leksiko kai se mia alli for prospelauno to leksiko
    for key in item.keys(): #to item einai leksiko ara pairno ta kleidia tou
        list2.append(item[key])

print(list2)