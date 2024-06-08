# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 5-8. Επεξεργασία λίστας – αλλαγή προσήμου (2ος τρόπος) 
numbers=[2,-4,1,-3,4,2,0,-12]
for i in range(len(numbers)):
    numbers[i]=numbers[i] if numbers[i]>=0 else -numbers[i]
print(numbers)
