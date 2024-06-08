"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple image viewer with status bar. GUI in Python
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

    #vazo imageNum + 2 gt ekso apo tin sunartisi exo grapsei image 1 of len(list) kai sto button gia forward exo grapsei current thesi to 0. An grapso imageNum+1 tha kollisei 2 fores sto 1 kai tha stamatisei to metrima 1 thesi prin to telos
    statusBar = Label(root, text = f'Image {imageNum + 2} of {len(my_list)}', bd = 1, relief = SUNKEN, anchor = E) 
    myLabel.grid(row = 0, column = 0, columnspan = 3)
    buttonBack.grid(row = 1, column = 0)
    buttonNext.grid(row = 1, column = 2)
    statusBar.grid(row = 2, column = 0, columnspan = 3, sticky = W + E) #sticky-> stretch in any direction...here we use west to east


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

    #edo grafo imageNum sketo gt ekso exo grapsei image 1 of len(list) kai an patiso px forward i current thesi einai i 0 kai auksanetai kata 1 ara einai 
    #h 0 + 1 = 1. An patiso tora back tha peraso san current thesi tin 1 stin parametro
    #kai tha tin meioso kata 1 ara thelo sketo imageNum gt den thelo na emfanizei to 0 alla na ksekinaei apo 1 ara panta tha exo 1 parapano
    statusBar = Label(root, text = f'Image {imageNum} of {len(my_list)}', bd = 1, relief = SUNKEN, anchor = E) 
    myLabel.grid(row = 0, column = 0, columnspan = 3)
    buttonBack.grid(row = 1, column = 0)
    buttonNext.grid(row = 1, column = 2)
    statusBar.grid(row = 2, column = 0, columnspan = 3, sticky = W + E) #sticky-> stretch in any direction...here we use west to east


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

#create a status bar
#bd = border
#anchor = where to place into the screen...for example east
statusBar = Label(root, text = f'Image 1 of {len(my_list)}', bd = 1, relief = SUNKEN, anchor = E) 

#create the buttons 
buttonBack = Button(root, text = 'Back', command = back, state = DISABLED)
buttonQuit = Button(root, text = 'Exit', command = root.quit)
buttonNext = Button(root, text = 'Next', command = lambda: forward(0)) #pass to the forward function the current place

#put buttons and status bar in to the screen
buttonBack.grid(row = 1, column = 0)
buttonQuit.grid(row = 1, column = 1)
buttonNext.grid(row = 1, column = 2, pady = 10)
statusBar.grid(row = 2, column = 0, columnspan = 3, sticky = W + E) #sticky-> stretch in any direction...here we use west to east

#the main loop of the program
root.mainloop()