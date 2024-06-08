"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

class Coin:
    def __init__(self):
        self.euro = 1
        self.yen = 136.5
        self.usaDollars = 0.99

    def convert2Yen(self, euroCoin):
        print(f'{euroCoin} euro = {self.yen * euroCoin} yen')

    def convert2UsaDollar(self, euroCoin):
        print(f'{euroCoin} euro = {self.usaDollars * euroCoin} usa dollars')


coins = Coin()
coins.convert2Yen(10)
coins.convert2UsaDollar(34)
