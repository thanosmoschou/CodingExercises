# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 7-8. Βασικά στατιστικά 
import random,math
x=tuple([random.randrange(-100,100) for _ in range(1000)])
mu=sum(x)/len(x)
s=sum([(i-mu)**2 for i in x])/(len(x)-1)
s2=s**(1/2)
print(mu,s,s2,math.sqrt(s))
