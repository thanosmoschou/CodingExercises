# -*- coding: utf-8 -*-
'''
Λίστες Κώδικα για το "Βιβλίο της Python"
@author: Σαμαράς Νικόλαος - Τσιπλίδης Κωνσταντίνος
@date: 2019
Εκδόσεις Κριτική
'''
#ΛΙΣΤΑ ΚΩΔΙΚΑ 10-35. Η συνάρτηση main – διαιρέτες 
def calc(x,k=[]):
    for i in range(1,x+1):
        if x%i==0:
            k.append(i)
    return k
    
def main():
    # εκκίνηση εκτέλεσης του προγράμματος
    num=int(input('Δώσε έναν αριθμό:'))
    nums=calc(num)
    print(*nums)
    
if __name__=='__main__':
    main()
