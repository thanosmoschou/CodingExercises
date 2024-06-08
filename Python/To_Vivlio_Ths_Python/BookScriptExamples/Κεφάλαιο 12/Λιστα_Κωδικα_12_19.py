# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-19. Εγγραφή σε αρχείο csv 
import csv
f=open('csv.txt',newline='')
rdr=csv.reader(f,delimiter=',')
list0=list(rdr)
list0[0].append('Αξία')
for i in range(1,len(list0)):
    list0[i].append(float(list0[i][2])*float(list0[i][3]))
f.close()
f=open('csv2.txt','w',newline='')
writer = csv.writer(f)
writer.writerows(list0)
f.close()
