"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple image viewer with GUI in Python
"""                                                                                                        

from tkinter import *
from PIL import ImageTk, Image
import os

#functions for buttons
def forward(imageNum):
    #these need to be visible from everywhere
    global myLabel
    global buttonNext
    global buttonBack

    if imageNum + 1 < len(my_list): #elegxos an eimai entos listas. H current thesi tha einai i imageNum + 1
        myLabel.grid_forget()
        myLabel = Label(image = my_list[imageNum + 1])
        buttonNext = Button(root, text = 'Next', command = lambda: forward(imageNum + 1)) #orizo pali ta buttons. Sto forward panta einai h current thesi. Afou afksisa tin thesi tora auti einai h current. To anapodo gia previous
        buttonBack = Button(root, text = 'Back', command = lambda: back(imageNum + 1))

    if imageNum + 1 == len(my_list) - 1: #an eimai stin teleutaia foto na min patietai to next
        buttonNext = Button(root, text = 'Next', state = DISABLED)

    myLabel.grid(row = 0, column = 0, columnspan = 3)
    buttonBack.grid(row = 1, column = 0)
    buttonNext.grid(row = 1, column = 2)

def back(imageNum):
    global myLabel
    global buttonNext
    global buttonBack

    if imageNum - 1 >= 0: #elegxos na min ksefigo arnitika tis listas dil o index na min ginei mikroteros tou 0
        myLabel.grid_forget()
        myLabel = Label(image = my_list[imageNum - 1])
        buttonNext = Button(root, text = 'Next', command = lambda: forward(imageNum - 1))
        buttonBack = Button(root, text = 'Back', command = lambda: back(imageNum - 1))

    if imageNum - 1 == 0: #eimai stin proti foto tis listas
        buttonBack = Button(root, text = 'Back', state = DISABLED)

    myLabel.grid(row = 0, column = 0, columnspan = 3)
    buttonBack.grid(row = 1, column = 0)
    buttonNext.grid(row = 1, column = 2)

#main program
root = Tk()
root.title('Thanos Moschou')
#root.iconbitmap() #in windows just paste the path of .ico file 

#take all the photos from the folder
photoList = os.listdir()
photoList = [item for item in photoList if (item.endswith('.jpg') or item.endswith('.png'))]

#create PhotoImage objects in order to print photos to the screen and put those objects to a list
# myImg1 = ImageTk.PhotoImage(Image.open('1.png'))
# myImg2 = ImageTk.PhotoImage(Image.open('2.jpg'))
# myImg3 = ImageTk.PhotoImage(Image.open('3.jpg'))

my_list = []
for item in photoList:
    my_list.append(ImageTk.PhotoImage(Image.open(item)))

#create a label and put it to the screen
myLabel = Label(image = my_list[0])
myLabel.grid(row = 0, column = 0, columnspan = 3)

#create the buttons and put them in to the screen
buttonBack = Button(root, text = 'Back', command = back, state = DISABLED)
buttonQuit = Button(root, text = 'Exit', command = root.quit)
buttonNext = Button(root, text = 'Next', command = lambda: forward(0)) #pass to the forward function the current place

buttonBack.grid(row = 1, column = 0)
buttonQuit.grid(row = 1, column = 1)
buttonNext.grid(row = 1, column = 2)

#the main loop of the program
root.mainloop()