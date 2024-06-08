"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

class Radio:
	def __init__(self):
		self.fm = list(['zoo', 'plus', 'laikos', '89 rainbow'])
		self.volume = randint(0, 30)
		self.radioIndex = randint(0, len(self.fm) - 1)
		self.radio = self.fm[self.radioIndex]

	def openRadio(self):
		print('Radio is open!')

	def closeRadio(self):
		print('Radio is closed...')
    	
	def nextFm(self):
		self.radioIndex += 1
		self.radio = self.fm[self.radioIndex]
    
	def previousFm(self):
		self.radioIndex -= 1
		self.radio = self.fm[self.radioIndex]

	def volumeUp(self):
		self.volume += 1
   
	def volumeDown(self):
		self.volume -= 1
     

def prompt():
	print('Please enter one of the following:\n{0:2d} Open the radio\n{1:2d} Change to the next radio station\n{2:2d} Change\
to the previous radio station\n{3:2d} Volume up\n{4:2d} Volume down\n{5:2d} Turn off the radio'.format(1, 2, 3, 4, 5, 6))

def main():       
	greekRadio = Radio()
	while True:
		prompt()
		decision = int(input('Please enter your choice '))
		if decision < 1 or decision > 6:
			print('Please enter valid data...')
		elif decision == 1:
			greekRadio.openRadio()
		elif decision == 2:
			greekRadio.nextFm()
		elif decision == 3:
			greekRadio.previousFm()
		elif decision == 4:
			greekRadio.volumeUp()
		elif decision == 5:
			greekRadio.volumeDown()
		elif decision == 6:
			greekRadio.closeRadio()
			break

		print(f'FM: {greekRadio.radio}, Volume: {greekRadio.volume}')

if __name__ == '__main__':
	main()