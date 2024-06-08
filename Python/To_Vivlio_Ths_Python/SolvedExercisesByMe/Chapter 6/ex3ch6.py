"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter a message: ")
ctr1 = 1 #an ksekiniso apo to 0 den exo metro sugkrisis xarakthron

for char in message:
    #thelo kathe xarakthra pou emfanizo sthn othoni na min ton emfaniso ksana. Ara koitao an ksanaemfanizetai. An nai tote paraleipetai
    #mexri na ftaso sthn teleutaia emfanisi tou charakthra kata thn sarosi kai na emfaniso to plithos emfanisis tou
    if message.find(char, ctr1) == -1:
        print(char, message.count(char))
    ctr1 += 1