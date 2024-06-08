# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-11. for – μετεωρολογικός σταθμός 
minn=100
s1=s2=0
p1=p2=0
for _ in range(5):
    temp=float(input('Θερμοκρασία:'))
    s1+=temp
    if temp<minn:
        minn=temp
        p2=0
    if temp==minn:
        p2+=1
    if temp<0:
        p1+=1
        s2+=temp
mt1=s1/15
print('Μέση Θερμοκρασία:',mt1)
if p1:
    mt2=s2/p1
    print('Αρνητικές θερμοκρασίες:',p1)
    print('Μέση Θερμοκρασία (<0)',mt2)
else:
    print('Καμία αρνητική θερμοκρασία')
print('Την πιο χαμηλή θερμοκρασία',minn)
print('είχαν',p2,'σταθμοί')
