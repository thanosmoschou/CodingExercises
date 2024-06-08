# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-22. Χρήση παραμέτρων – στοιχεία λίστας 
def multi(x):
    mymin=min(x)
    mymax=max(x)
    s=sum(x)
    return mymin, mymax, s
    
mylist=[-3,4,2,1,5,0]
a,b,c=multi(mylist)
print('Min=',a,'Max=',b,'Sum=',c)
mytuple=multi(mylist)
print('(Min,Max,Sum)',mytuple)
