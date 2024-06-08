"""
Author: Thanos Moschou
Date: 09/2022
Description: Images, icons and exit buttons with GUI in Python
"""                                                                                                        

from tkinter import *
from PIL import ImageTk, Image

#the main window
root = Tk()
root.title('Thanos Moschou')
#root.iconbitmap() #in windows just paste the path of .ico file 

myImg = ImageTk.PhotoImage(Image.open('icon1.png'))
myLabel = Label(image = myImg)
myLabel.pack()

#buttons
buttonQuit = Button(root, text = 'Exit', command = root.quit)
buttonQuit.pack()

#mail loop
root.mainloop()