"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#pairnoume sinolo kefalion kai podion kai vriskoume ta kounelia kai tis kotes
#thelo 2 eksisoseis
#C + R = H opou C chicken, R rabbit, H head
#2C + 4R = L opou L legs
#lino tin proti os pros C kai tin deuteri os pros C. Prota meli isa ara kai ta deutera isa ara eksisono ta deutera meli kai lino os pros R
#C = H - R
#C = (L-4R) / 2
#H-R = (L-4R)/2 ara H-R = L/2 - 2R kai R = L/2 - H lino os pros R kai meta to R to vazo stin C = H - R kai to vrika
#ston kodika mou tha valo tin eksisosi R = L/2 - H kai C = H - R
def findChickenRabbit(head, feet):
    rabbits = (feet // 2) - head
    chicken = head - rabbits

    return rabbits, chicken

def main():
    data = input('Enter number of heads and number of feet with format -> numOfHead numOfFeet: ').split()
    head, feet = data #unpack
    head, feet = int(head), int(feet)

    print(f'Rabbits and Chickens are: {findChickenRabbit(head, feet)}')

if __name__ == '__main__':
    main()