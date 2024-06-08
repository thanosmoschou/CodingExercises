"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#This thing works correct for a couple of messages but is not accurate at other messages

message1 = "until as customer service at Vodafone."

message2 = "My name is Thanasis. Now I am on vacation until I start to work as customer service agent at Vodafone."

list1, list2 = message1.split(), message2.split()

minLimDistMessageCheck = len(list1) if len(list1) < len(list2) else len(list2) #the sortest message in order not to get out of range in the list

lim1 = max = endLim = dist = 0
finalList = []

for i in range(len(list1)):
    lim1 = endLim = i #the current position in the 1st message
    for j in range(len(list2)):
        if list1[i] == list2[j]: #same words in the two different messages. Search if the equality exists from now on word by word. If it is not continue         
            for k in range(i if len(list1) < len(list2) else j, minLimDistMessageCheck): #searching word by word. Take as guide the sortest messsage and the current word on this message
                if k + i < len(list1) and k + j < len(list2): #this is the reason i did this in the line 7. I want to be sure that i will not be out of range. I have useless positions but ok...
                    if list1[k + i] == list2[k + j]:
                        endLim += 1
                    else:
                        break
    dist = endLim - lim1 
    if dist > max: #the length is bigger
        max = dist
        finalList.clear()
        for l in range(lim1, endLim):
            finalList.append(list1[l])
print(finalList)
