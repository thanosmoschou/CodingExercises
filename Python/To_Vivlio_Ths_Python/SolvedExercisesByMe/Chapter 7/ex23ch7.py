"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

message = input("Please enter your message here: ")
message = message.split()

tup = ()

for i in range(len(message)):
    found = False
    for j in range(i, len(message[i + 1:])): #thelo plithos ara koitao an mia leksi emfanizetai ksana oste na thn emfaniso mia fora mono. Ara thn paraleipo mexri na ftaso sthn teleutaia emfanisi ths kai na psakso poses fores emfanizetai
        if message[i] == message[j]:
            found = True
            break
    if not found:
        tup = tup + ((message[i], message.count(message[i])))

print(tup)