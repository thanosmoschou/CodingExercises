"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def funcInput():
    return int(input('Enter a number: '))

def funcListInsert(num, list1):
    list2 = []

    if len(list1) == 0:
            list2.append(num)
            return list2
    elif len(list1) == 1:
        if num > list1[0]:
            list2 = [list1[0], num]
        else:
            list2 = [num, list1[0]]

        return list2       
        
    for i in range(len(list1)):
        if num > list1[i]: #to num einai megalitero ara prepei na pao pio pera...ara prostheto ta poigoumena stoixeia tis listas afou ta sigkrina me to num 
            list2.append(list1[i])
        else: #to num einai mikrotero h iso me ton current arithmo poy sigkrino ara prepei na to valo anamesa ston current kai ton previous pou sigkrina
            if len(list1) == 2:
                list2 = [num, *list1]
                break
            else:
                list2 = [*list1[:i], num, *list1[i:]]
                break
    else: #ftasame sto telos tis listas kai to num einai to megalitero
        list2.append(num)
        
    return list2

def main():
    list1 = []
    while True:
        list1 = funcListInsert(funcInput(), list1)
        print(list1)
        # while input('Press N or n to stop ').upper() != 'N':
        #     break
        # else:
        #     return 0

if __name__ == '__main__':
    main()