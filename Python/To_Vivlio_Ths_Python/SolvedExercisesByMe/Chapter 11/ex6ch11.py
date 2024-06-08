"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

#vs code makes blue the attributes that I initialized first in this class and white those attributes that I initialized outside  of this class
class Employee:
    def __init__(self, name, am, misthos, proipiresia, auksisi, tmima): #to self einai to antikeimeno sto opoio tha mpoun oi idiotites autes.Mporo na min tis arxikopoihso oles edo.Episis se epomenes methodous mporo  na xrisimopoihso idiotites pou den arxikopoihsa edo alla sthn upoklasi mou
        self.name = name
        self.am = am
        self.misthos = misthos
        self.proipiresia = proipiresia
        self.arxMisthos = misthos
        self.auksisi = auksisi
        self.tmima = tmima

    def afksisiFind(self):
        if self.proipiresia >= 5 and self.proipiresia <= 10: #den einai anagki na arxikopoiithikan edo. Mporousan kai stin upoklasi mou. Apla prepei to antikeimeno na exei tis idiotites pou thelo na xrhsimopoihso
            self.auksisi = 0.1 * self.arxMisthos
            self.misthos = self.auksisi + self.arxMisthos
        elif self.proipiresia > 10:
            self.auksisi = 0.2 * self.arxMisthos
            self.misthos = self.auksisi + self.arxMisthos
    
    def info(self):
        self.afksisiFind()
        print(f'Onoma: {self.name}\nTmima: {self.tmima}\nAM: {self.am}\nRolos: {self.rolosTmimatos}\nProipiresia: {self.proipiresia} xronia\nArxikos Misthos: {self.arxMisthos}\nAuksisi: {self.auksisi}\nTelikos Misthos: {self.misthos}\n')
        
class DepartmentA(Employee):
    def __init__(self, name, am, misthos, proipiresia, rolosStoTmima, auksisi = 0, tmima = 'A'):
        super().__init__(name, am, misthos, proipiresia, auksisi, tmima)
        self.rolosTmimatos = rolosStoTmima

    def afksisiDepA(self):
        super().afksisiFind()
        return f'Arxikos Misthos: {self.arxMisthos} Auksisi: {self.auksisi} Telikos Misthos: {self.misthos}\n'

class DepartmentB(Employee):
    def __init__(self, name, am, misthos, proipiresia, rolosStoTmima, auksisi = 0, tmima = 'B'):
        super().__init__(name, am, misthos, proipiresia, auksisi, tmima)
        self.rolosTmimatos = rolosStoTmima

    def afksisiDepB(self):
        super().afksisiFind()
        return f'Arxikos Misthos: {self.arxMisthos} Auksisi: {self.auksisi} Telikos Misthos: {self.misthos}\n'

kostas = DepartmentA('Kostas Athanasiou', 12345, 1200, 5, 'Xeiristis')
kostas.info()
john = DepartmentB('John Kokkinos', 35465, 900, 12, 'IT')
john.info()