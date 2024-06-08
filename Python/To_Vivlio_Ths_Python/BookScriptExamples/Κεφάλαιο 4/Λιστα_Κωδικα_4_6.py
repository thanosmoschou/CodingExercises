# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 4-6. for – αποτελέσματα εξετάσεων 
count1=count2=0
s=0
maxx=-1
for student in range(120):
    p=float(input('Προφορικός Βαθμός:'))
    g=float(input('Γραπτός Βαθμός:'))
    v=p*0.3+g*0.7#Ερώτημα α
    print('Τελικός Βαθμός:',v)
    if v>=5:
        print('Πέρασε')
        count1+=1   #Ερώτημα β
        s+=v
    else:
        print('"Κόπηκε"')
        if p>maxx:  #Ερώτημα δ
            maxx=p
    if p==0:    #Ερώτημα γ
        count2+=1
if maxx==-1:
    print('Δεν "κόπηκε" κανείς')    
else:
    print(maxx)
print('Πέρασαν',count1)    
if count1:
    print('Ο μέσος όρος τους',s/count1)    
else:
    print('Δεν πέρασε κανείς')
