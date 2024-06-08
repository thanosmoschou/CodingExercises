# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 9-36. Πολλαπλή επιλογή 
vehtype=input('Δώσε τον τύπο του οχήματος:') 
if vehtype=='Δίκυκλο':
    poso=30
elif vehtype=='Υγραέριο' or vehtype=='IX':
    poso=50
elif vehtype=='TAXI':
    poso=40
elif vehtype=='Φορτηγό':
    poso=60
elif vehtype=='Επαγγελματικό':
    poso=45
else:
    poso=35
print(f'Ποσό πληρωμής:{poso}')
