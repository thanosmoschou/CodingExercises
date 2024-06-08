"""
Author: Thanos Moschou
Date: 09/2022
Description: Buttons in the screen with GUI in Python
"""

from tkinter import *

def myClick():
    myLabel = Label(root, text = 'You clicked the button!')
    myLabel.pack()

#the main window of the program
root = Tk() #otan ftiaxneis pragmata me tkinter to proto poy tha grafeis einai ayto. Einai to parathiro mou

#create a button
myButton = Button(root, text = 'Click me!',padx = 10, pady = 20, command = myClick, fg = 'White', bg = 'Black') #vazo to button sto root parathiro
#an meta to text grapso state = DISABLED tote den mporei na patithei to koumpi
#me padx pady kano resize...skepsou san to epipedo me tis sintetagmenes x kai y. Vlepo posi apostasi exei to button apo ta akra
#me command = toOnomaTisFunction ektelei entoles otan patas to button...den vazeis () sto function
#giati an valeis tote tha ektelestei outos h allos i sinartisi sou
#me fg = 'Color' vazeis xroma sta grammata inside the button
#me bg = 'Color' vazeis xroma sto background tou button
#epeidi pernas tis parametrous me vasi tin onomasia mporeis kai mperdemena na tis valeis

#stin python mporo na valo tis parametrous me 2 tropous:
#me vasi tin thesi kai me vasi tin onomasia

myButton.pack() #put it in the screen

#create the main loop of the program
root.mainloop()
