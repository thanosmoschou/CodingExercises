"""
Author: Thanos Moschou
Date: 09/2022
Description: Entry Field with GUI in Python
"""

from tkinter import *

def myClick():
    #mess = f'Hello {entr.get()}'
    myLabel = Label(root, text = f'Hello {entr.get()}') #text = mess
    myLabel.pack()

#the main window
root = Tk() #otan ftiaxneis pragmata me tkinter to proto poy tha grafeis einai ayto. Einai to parathiro mou

#create an entry field
entr = Entry(root, width = 40, borderwidth = 10) #thelo to input box na einai sto root
#proairetika pairnei kai alles parametrous
#width gia allagi megethous platous
#bg, fg opos kai sta buttons gia background kai grammata antistoixa
#borderwidth gia platos tou plaisiou...dinei vathos
entr.pack() #to emfanizo stin othoni
#entr.get() #pairno oti exei dosei sto input plaisio
entr.insert(0, 'Enter your name') #vazo sto input box ena default message...index to 0 gt exo mono ena box ana insert object


#create a button
myButton = Button(root, text = 'Enter your name', command = myClick) #vazo to button sto root parathiro
myButton.pack() #put it in the screen

#create the main loop of the program
root.mainloop()
