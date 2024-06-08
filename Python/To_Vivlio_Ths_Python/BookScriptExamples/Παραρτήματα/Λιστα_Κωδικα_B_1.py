# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ Β-1. ΕΜΦΑΝΙΣΗ ΧΑΡΑΚΤΗΡΩΝ ASCII ΚΑΙ UNICODE 
print('-'*44*2)
for c in range(32, 128, 12):
    print('Chr:',end="")
    for c1 in range(c, c+12):
        print('%7s'%chr(c1), end="")
    print()
    print('Dec:',end="")
    for c2 in range(c, c+12):
        print('%7s'%c2, end="")
    print()
    print('Oct:',end="")
    for c2 in range(c, c+12):
        print('%7s'%str(oct(c2))[2:], end="")
    print()
    print('Hex:',end="")
    for c2 in range(c, c+12):
        print('%7s'%str(hex(c2))[2:], end="")
    print()
    print('Bin:',end="")
    for c2 in range(c, c+12):
        print('%7s'%str(bin(c2))[2:], end="")
    print()
    print('-'*44*2)
print('-'*17*4)
for c in range(880,1024,16):
    print('Chr:',end="")
    for c1 in range(c, c+16):
        print('%4s'%chr(c1), end="")
    print()
    print('Dec:',end="")
    for c2 in range(c, c+16):
        print('%4s'%c2, end="")
    print()
    print('Hex:',end="")
    for c2 in range(c, c+16):
        print('%4s'%str(hex(c2))[2:], end="")
    print()
    print('-'*17*4)
import unicodedata
print('%04s'%'A/A','%05s'%'Hex','%04s' %'Dec','%01s'%'Κ','%02s' %'Γρ','%04s' %'Ονομασία - Περιγραφή')
print('-'*17*4)
for i,c in enumerate(range(880,1024)):
    try:
        a=unicodedata.name(chr(c))
    except ValueError:
        continue
    print('%04s' %i, '%04s' % hex(c),'%04s' % c, end=" ")
    print(unicodedata.category(chr(c)), end=" ")
    print(chr(c), end=" ")
    print(unicodedata.name(chr(c)))
print('-'*17*4)