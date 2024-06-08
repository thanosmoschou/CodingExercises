"""
Author: Thanos Moschou
Date: 09/2022
Description: We learn how to open the file dialog and select an image to open
"""

from tkinter import *
from PIL import ImageTk, Image
from tkinter import filedialog


def dial():
    #global myLabel
    global image1
    global imageLabel

    #kapoia apo ta orismata pou pairnei to filedialog.askopenfilename einai
    #initialdir = 'path'...an den valeis to initialdir pairnei ton current folder
    #title = 'Oti titlo thelo' gia na vgalei pano sto parathiro
    #filetypes = (('description', 'kataliksi'), ('description', 'kataliksi')) opou kataliksi mporo na valo px *.png dil * = oti onoma kai na exei den me peirazei-> wildcard
    #prosexe omos thelo tuple timon kai mesa tuple
    #Note: epistrefei to location tou arxeiou pou epilego kai den to anoigei
    root.filename = filedialog.askopenfilename(title = 'Select a file', filetypes = (("png files", "*.png"),)) #("all files", "*.*")))
    
    #myLabel = Label(root, text = root.filename).grid(row = 0, column = 0) #epistrefo stin othoni to location tou arxeiou pou epilego

    #open the image. 
    image1 = ImageTk.PhotoImage(Image.open(root.filename))
    imageLabel = Label(root, image = image1).grid(row = 1, column = 1)


#main window
root = Tk()
root.title('Open the file dialog')

#buttons
buttonForDialog = Button(root, text = 'Click to open file dialog', command = dial).grid(row = 0, column = 1)

#main loop
root.mainloop()