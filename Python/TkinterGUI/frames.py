"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple frames with GUI in Python
"""       

from tkinter import *
from PIL import ImageTk, Image

#the main window of my program
root = Tk()
root.title('Frames with Python')

#sinithos den mporoume na kanoume grid kai pack mazi gt den tha doulevei kala to programma. Tha kanoyme eite pack kai pack eite grid kai grid
#edo sta frames omos mporoume
#pack->apla ta petao stin othoni
#grid->topotheto ego opou thelo stin othoni
frame = LabelFrame(root, text = 'This is a frame...', padx = 50, pady = 50) #ta padx, pady einai esoterika sto frame
frame.pack(padx = 10, pady = 10) #ta padx pady einai eksoterika apo to frame

#my buttons
button = Button(frame, text = 'Click me')
button.grid(row = 0, column = 0)

button2 = Button(frame, text = 'Do not click this...')
button2.grid(row = 1, column = 2)

#main loop of the program
root.mainloop()