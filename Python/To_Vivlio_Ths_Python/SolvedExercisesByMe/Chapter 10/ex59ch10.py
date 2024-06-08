"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def checkValidityVATNumber(vat):
    numList = []
    while True: #spao ton arithmo mou kai vazo ta psifia se lista. Ta psifia mpainoun anapoda se authn thn lista
        if vat // 10 == 0 and vat % 10 == 0:
            break
        else:
            dig = vat % 10
            vat //= 10
            numList.append(dig)
    #ta psifia mpikan anapoda ara tha kano prospelasi anapoda tin lista
    print(numList)

    constants = 256 #auto se kathe loop ginetai to miso kathos etsi orizei o algorithmos egkirotitas tou afm
    sumDig = 0
    for i in range(8, 0, -1): #tha paei apo 8 os 1 dil elegxei ta prota 8 noumera tou afm
        #print(i, numList[i])
        sumDig += (constants * numList[i])
        constants //= 2
    
    modWith11 = sumDig % 11 #upologizo to ipolipo tis diairesis tou sum me to 11
    #print(modWith11)
    lastDigOfModWith11 = modWith11 % 10 #an to teleutaio psifio tou upoloipou einai iso me to teleutaio psifio tou afm tote to afm einai egkiro
    #print(lastDigOfModWith11)

    if lastDigOfModWith11 == numList[0]: #to teleutaio psifio tou afm einai sthn proti thesi tis listas
        return True
    else:
        return False

def main():
    #ipotheto oti vazei sosta stoixeia gia na min kano validity check
    vatNum = int(input('Please enter your VAT number: '))
    print(vatNum, ['is not valid', 'is valid'][checkValidityVATNumber(vatNum)])
    
    return 0

if __name__ == '__main__':
    main()
