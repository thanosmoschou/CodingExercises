"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple checkboxes with gui in Python
"""

from tkinter import *
from PIL import ImageTk, Image

#functions
def show():
    label = Label(root, text = var.get())
    label.pack()

#create the main window
root = Tk()
root.title("Let's create checkboxes")
root.geometry("400x400")

#my variable where i store the value(1 if the box is checked, 0 if it is not)
var = IntVar() #the default values if we check the box is 1 and if we not 0...although we can change the default values
#var = StringVar()

#my checkbox
#in the parameters i can use onvalue = 'something' and offvalue = 'something' and this is how i can change the default values 0 and 1 to something else
checkBox = Checkbutton(root, text = 'Check this box', variable = var)
#an exo stringvar kai valo onvalue kai offvalue tote tha exo thema gt erxetai protikarismeno to checkbox
#kai den to thelo...mallon einai glitch tou tkinter...tha xrisimopoihso prin to checkBox.pack() to checkBox.deselect()
checkBox.pack()

#my button...if you press it it will show the value of the box
button = Button(root, text = 'Show selection', command = show).pack()

#the main loop of the program
root.mainloop()