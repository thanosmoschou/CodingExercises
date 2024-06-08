"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

encryptedMessage = "P|#qdph#lv#Wkdqdvlv1L#dp#4<#|hduv#rog#dqg#L#dp#d#vwxghqw#dw#XrP1D#ihz#gd|v#djr#L#ilqlvkhg#p|#h{dp#shulrg1Qrz#L#dp#rq#ydfdwlrq#xqwlo#L#vwduw#wr#zrun#dv#fxvwrphu#vhuylfh#djhqw#dw#Yrgdirqh1"

decryptedMessage = "\0"

key = int(input("Please enter the key for the Ceasar Decryption Algorithm(Note that you must insert \
the same key that you used for the encryption otherwise it won't work): "))

for char in encryptedMessage:
    if char != '\n':
        newChar = ord(char) - key
        newChar = chr(newChar)
        decryptedMessage = decryptedMessage + newChar
    else:
        decryptedMessage = decryptedMessage + char
        
print(decryptedMessage)
