"""
Author: Thanos Moschou
Date: 09/2022
Description: A hello world with GUI in Python
"""

from tkinter import *

root = Tk() #otan ftiaxneis pragmata me tkinter to proto poy tha grafeis einai ayto

#create a label widget
myLabel = Label(root, text = 'Hello Thanasis here.') #vazo root gt thelo ekei na to valo
#put the label in to the screen
myLabel.pack()

#create the main loop of the program
root.mainloop()
