"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

""" 
abc	acb bac bca cab cba   gia to kathe gramma isxuei: 2 fores 1o, 2 fores 2o kai 2 fores 3o
--- --- --- --- --- ---

"""

import math

#dict1 = {}
message = input("Please enter your message here: ")
list1 = []
for i in range(math.factorial(len(message))):   #vazo listes mesa se lista gia na sumvoliso tis pithanes anaparastaseis ths leksis
	list1.append([' ']*len(message))            #me vasi tis pithanotites otan exo n stoixeia oi metatheseis
                                            	#dhl oles oi pithanes periptoseis pou mporo na ta valo se seira einai n!
                                               	#ara thelo n! ypolistes. Arxikopoio tis theseis me ' ' toses fores oso to mikos ths leksis

for char in message:
	ctr = 0                            
	for i in range(math.factorial(len(message))):
		if i % len(message) - 1 == 0: #hrthe i ora na allakso thesi topothetisis gia to gramma mou afou se kathe thesi einai n-1 fores ara ana n-1 listes allazo thn thesi topothetisis
			ctr += 1
		
		for k in range(len(message) - 1):
			if list1[i + k][ctr] == ' ':
				list1[i + k][ctr] = char
		
		

print(list1)