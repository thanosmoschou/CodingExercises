"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter a message: ")
list1 = message.split()

for ctr1 in range(len(list1)):
    found = False
    #thelo kathe leksi pou emfanizo sthn othoni na min tin emfaniso ksana. Ara koitao an ksanaemfanizetai. An nai tote paraleipetai
    #mexri na ftaso sthn teleutaia emfanisi ths leksis kata thn sarosi kai na emfaniso to plithos emfanisis ths
    for ctr2 in range(ctr1 + 1, len(list1)):
        if list1[ctr2] == list1[ctr1]:
            found = True
            break
    if not found:
        print(list1[ctr1], list1.count(list1[ctr1]))