"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple drop down box in python
"""

from tkinter import *
from PIL import ImageTk, Image

#functions for the buttons
def show():
    sLabel = Label(root, text = clicked.get())
    sLabel.pack()


#create the main window
root = Tk()
root.title("Let's make a drop down box")
root.geometry('400x400')

#drop down boxes

#create the variable where we store the value of the selection
options = ['Option 1', 'Option 2', 'Option 3']

clicked = StringVar()
clicked.set(options[0]) #with set we set a default value

#we have the variable(clicked) where we store the value and we some some values after the definition of the variable
#if we use a list we will put it like *myList
drop = OptionMenu(root, clicked, *options)
drop.pack()

#create a button
myButton = Button(root, text = 'Click me', command = show)
myButton.pack()

#the main loop of the program
root.mainloop()