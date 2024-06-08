"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#acceptProtocolUrl = "http:// https://"
#list1 = acceptProtocolUrl.split()

# acceptDomainUrl = ".gr .com .edu .us .org" #this is only a sample of domains
# list2 = acceptDomainUrl.split()

message = input("Please enter your message: ")
list3 = message.split()
findUrl = False

for ctr in range(len(list3)):
    if ((list3[ctr].startswith("http://") or list3[ctr].startswith("https://")) and list3[ctr].count("/") == 2) and (list3[ctr].endswith(".gr") and list3[ctr].count(".") == 1): #only for greek url
        print(f"The message contains a hyperlink with greek domain: {list3[ctr]}")
        findUrl = True

if not findUrl:
    print("The message does not contain a greek domain hyperlink.")