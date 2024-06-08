"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

tup = (('dasfla', 'gmail.com'), ('dafgsgs', 'yahoo.com'), ('ssafijgi', 'hotmail.com'), ('weijeg', 'otenet.gr'))
emailTup = ()

for item in tup: #kathe fora to item ginetai iso me thn kateh pleiada. Meta me extra deiktodotisi pairno ta dedomena tis antistixis pleiadas
    emailTup += (item[0] + '@' + item[1]),

print(f'New email tupple:\n{emailTup}')