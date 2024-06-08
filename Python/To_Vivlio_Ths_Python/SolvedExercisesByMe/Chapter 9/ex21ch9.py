"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

inform = ((1234, 'Mos', 'dfd@gmail.com'), (4354, 'sfd', 'dffgf@gmail.com'), (2145, 'dfjfgjf', 'fdkfgf@yahoo.gr'))

dict1 = {}
for item in inform:
    dict1[item[0]] = [item[1:]] #slicing den mporo na kano se mi diatetagmena antikeimena opos leksika kai sunola. Se listes kai pleiades mporo

print(dict1)