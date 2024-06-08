# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 8-8. Ένωση 
a,b={1,2,3},{2,3,4}
a|b
s1,s2={'python','perl'},{'C','C++','C#'}
s3=s1|s2
s4=s1.union(s2)
s3#ιδιο με s4
{'python'}|{'java'}
{'python'}.union('java')
{'python'}.union({'java'})
