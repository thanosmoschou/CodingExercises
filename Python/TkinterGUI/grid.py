"""
Author: Thanos Moschou
Date: 09/2022
Description: Place the labels in different positions on the screen with GUI in Python
"""

from tkinter import *

#the main window
root = Tk() #otan ftiaxneis pragmata me tkinter to proto poy tha grafeis einai ayto. Einai to parathiro mou

#create a label widget
myLabel1 = Label(root, text = 'Hello Thanasis here.')
myLabel2 = Label(root, text = 'Hello Thanasis here.')
myLabel3 = Label(root, text = 'Hello Thanasis here.')

#put the label in to the screen but in certain position
#note that labels are relative so if you put label 1 in row 0 col 0 and label 2 in row 1 col 4 it will show
#just like label 1 is in row 0 col 0 and label 2 in row1 col 1 because the lines between them are empty 
myLabel1.grid(row = 0, column = 0)
myLabel2.grid(row = 1, column = 1) #col 2 is empty so tkinter ignores it and shows the 2 phrases side by side
myLabel3.grid(row = 1, column = 3)

#alternative way
# myLabel2 = Label(root, text = 'Hello Thanasis here.').grid(row = 0, column = 0)
# myLabel3 = Label(root, text = 'Hello Thanasis here.').grid(row = 1, column = 1)
# myLabel1 = Label(root, text = 'Hello Thanasis here.').grid(row = 1, column = 3)

#create the main loop of the program
root.mainloop()
