# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 12-16. Διαχείριση pickle 
import pickle
list1=[('π',3.14),['e',2.72]]
dict1={'π':3.14,'e':2.72}
f=open('pickle.bin','wb')
pickle.dump(list1,f)
pickle.dump(dict1,f)
f.close()
f=open('pickle.bin','rb')
a=pickle.load(f)
b=pickle.load(f)
print(a,’\n’,b)
f.close()
