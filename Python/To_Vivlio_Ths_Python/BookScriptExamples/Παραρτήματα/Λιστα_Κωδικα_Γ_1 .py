# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ Γ-1. ΥΠΟΛΟΓΙΣΜΟΣ ΤΩΝ ΠΡΩΤΩΝ 3,141 ΨΗΦΙΩΝ ΤΟΥ Π 
n=3_141
import decimal
decimal.getcontext().prec = 3_141
π=decimal.Decimal(0)
i=decimal.Decimal(0)
while i<n:
    π=π+(1/16**i)*(4/(8*i+1)-2/(8*i+4)-1/(8*i+5)-1/(8*i+6))
    i+=1
print(π)