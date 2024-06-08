"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

key = 2
################## ENCRYPTION #####################
with open('ex4ch12.dat', 'r') as encr: #take characters for encryption
    data = encr.read()
    dataEnc = []

    for item in data:
        if item != '\n':
            dataEnc.append(ord(item) + key) #pairno ton ascii kodiko ton auksano kai emfanizo ton char pou antistixei
        else:
            dataEnc.append(ord(item))

dataEnc = bytearray(dataEnc)
with open('encrypt.bin', 'wb') as encr: #write encrypted characters in to a binary file
    encr.write(dataEnc)

with open('encrypt.bin', 'rb') as readFile: #read the binary file
    data = readFile.read()
    print(data)

############ DECRYPTION #########################
with open('encrypt.bin', 'rb') as decrypt: #take the encrypted characters for decryption
    data = decrypt.read()
    decr = ''
    #data = str(data) #tis akolouthies apo bytes tis thelo na ginoun string
    
    for item in data:
        if item != '\n':
            decr += (chr(ord(chr(item)) - key)) #idio me pano apla meiono ton ascii kodiko gia ton char pou tha emfaniso
            #decr += chr(ord(item) - key) #to pano to exw an den metatrepso arxika oti diabasa apo to binary se string
        else:
            #decr += item
            decr += chr(item)

with open('decrypt.dat', 'w') as writeDecrypt: #write the decrypted characters into a text file
    writeDecrypt.write(decr)

with open('decrypt.dat', 'r') as readDecr: #read the file
    data = readDecr.read()
    print(data)