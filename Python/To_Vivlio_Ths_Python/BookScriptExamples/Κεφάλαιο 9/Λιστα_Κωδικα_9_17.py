# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-17. Εμφώλευση – τράπουλα 
from random import randint 
cards={'shape':['Καρδιές','Καρώ','Σπαθί','Μπαστούνι']}
cards['figure']=list(range(1,11))+['Βαλές','Ντάμα','Ρήγας']
print(cards['figure'][randint(0,12)], cards['shape'][randint(0,3)])
