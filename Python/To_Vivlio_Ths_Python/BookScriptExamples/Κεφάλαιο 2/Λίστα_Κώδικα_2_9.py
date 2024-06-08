# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#Λίστα Κώδικα 2-9. Ρυθμίσεις decimal 
Decimal(22/7)#Δημιουργία ενός Decimal με 51 ψηφία 
Decimal(22)/Decimal(7)  #28 ψηφία (βάσει context)
getcontext().prec=4  #Αλλαγή context, με 4 ψηφία ακρίβεια
Decimal(22)/Decimal(7)  
getcontext().prec=8  #Αλλαγή context, με 8 ψηφία ακρίβεια
Decimal(22)/Decimal(7)  
setcontext(DefaultContext)  #Ορισμός αρχικών παραμέτρων
getcontext()  
setcontext(ExtendedContext)  #Μια άλλη προρύθμιση
getcontext()  #9 ψηφία, χωρίς traps
