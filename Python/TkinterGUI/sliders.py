"""
Author: Thanos Moschou
Date: 09/2022
Description: We learn how to create sliders in Python
"""

from tkinter import *
from PIL import ImageTk, Image

#update the number from the horizontal slider into the screen
def slide():
    #myLabel = Label(root, text = horizontal.get()).pack()
    root.geometry(str(horizontal.get()) + "x" + str(vertical.get())) #this determines how big the root window will be...resize the window every time

#the main window
root = Tk()
root.title('Sliders')
root.geometry("600x600") #this determines how big the root window will be

#create the scale widget
vertical = Scale(root, from_ = 0, to = 600) #i need from_ to determine the start and to in order to determine the end of the slider
vertical.pack() #edo den tha doulevei an kano pack stin idia grammi pou eftiaksa to widget...thelei ksexoristi grammi

horizontal = Scale(root, from_ = 0, to = 600, orient = HORIZONTAL) #an den valo orient theoreitai default VERTICAL
horizontal.pack()

#horizontal.get() return the number from the slider

#create a button to show the value of the slider(horizontal) in to the screen
button = Button(root, text = 'Click me', command = slide).pack()

#the main loop of the program
root.mainloop()