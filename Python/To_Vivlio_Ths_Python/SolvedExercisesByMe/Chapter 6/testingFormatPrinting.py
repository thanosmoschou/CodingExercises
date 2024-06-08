"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#DES KALITERA TO VIVLIO THS PYTHON
#Anaskopisi ton tropon morfopoihshs me tous opoipous mporo na ektiposo dedomena

###############################################################################

#numbers

#format method
a = format(10.2343, "8.3f") #H mona autakia '' einai to idio
print(a)

#mofropoihsh ypoloipou
print("%d%d%f" %(1,2,3.5))
#an thelo 1 arithmo
print("%d"%12)
print(12)
###############################################################################
#strings PROSOXI an arxizeis me " na teleioneis to string sou me ", an arxizeis me ' teleiose me '. Mhn kaneis " ... ' h ' ... " den tha trexei
print("Ena", "Ena") #xorizo ta orismata me , ara anamesa tous mpainei o kenos xarakthras
print("Ena" + "Ena") #xorizo ta orismata me + ara kollane metaksi tous xoris keno
print("Ena", "Ena", sep = "+")

print("Ena", "Ena", sep = "+", end = "=") #kathe string by default exei sto telos \n diladi na paei sthn kato grammi. An valo end = "char"
#tote sto telos anti gia \n exei auton ton charactira pou epeleksa kai i epomeni seira print tiponetai stin idia grammi
print(2)

#string kai noumera me format method
print("Keimeno: {0} kai {1} mou kanei {2}".format(2, 4, 6)) #min ksexnas thn . meta to " h ' oti exeis valei

#string kai noumera me morfopoihsh ypoloipou
print("kati akyro:%d%d%f" %(1,2,3.5))
#mesa sta {} exo to orisma pou thelo na emfaniso apo tin format sunartisi. Mporo episis na antistrepso thn seira pou thelo na ta emfaniso allazontas apla to noumero mesa sta {}. Ta noumera sta {} ksekinane apo 0
print("Keimeno: {1} kai {0} mou kanei {2}".format(2, 4, 6))

#sta {} ektos apo mono ena noumero mporo na exo plirofories gia thn morfi emfanisis tou arithmou. Me :
print("Keimeno: {0: 4d} kai {1: 3.3f} mou kanei {2}".format(2, 4, 6))

#ektiposi me f format
a = 10
print(f"to a einai {a}. To antistrofo einai {1/a}")
#dil grafo f"keimeno{ekfrasi}" opou ekfrasi mia ekfrasi pou periexei dedomena px prakseis. Oti emfaniseis apo metavliti na to exeis orisei prin

#boolean
a = 2
b = 3
print("a<b?", a < b)
