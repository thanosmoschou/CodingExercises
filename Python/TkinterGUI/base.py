"""
Author: Thanos Moschou
Date: 09/2022
Description: We learn how to create another window despite the root one in Python
"""

from tkinter import *
from PIL import ImageTk, Image

#we do not want to show different windows with no reason in our program. This is why we create a function
#for our button. When user presses the button then the new window appears
def clicked():
    global image1
    
    top = Toplevel() #this creates another window. We can put anything we want just like the root window
    top.title('New window')
    #label = Label(top, text = 'Hello') #we put the label to the new window

    #open an image into the new window
    image1 = ImageTk.PhotoImage(Image.open('1.png'))
    label2 = Label(top, image = image1).grid(row = 0, column = 0)

    #exit button for the new window
    button2 = Button(top, text = 'Exit', command = top.destroy).grid(row = 1, column = 0) #an evaza quit tha ekleine to programma molis patousa to button

#the main window of the program
root = Tk()
root.title("Let's create another one window!")

#my buttons
button = Button(root, text = 'Click this to open the 2nd window.', command = clicked).grid(row = 0, column = 1)

#main loop of the program
root.mainloop()