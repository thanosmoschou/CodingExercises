"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple message boxes with GUI in Python
"""    

from tkinter import *
from PIL import ImageTk, Image
from tkinter import messagebox


#several types of boxes that we can show:
#showinfo, showwarning, showerror, askquestion, askokcancel, askyesno, askyesnocancel, askretrycancel
def popUp():
    # messagebox.showinfo('This is my pop up!', 'My name is Thanos') #1st parameter is title bar and 2nd one is the message inside the pop up window
    # messagebox.showwarning('This is a pop up', 'Warning...Be careful with pop ups')
    # messagebox.showerror('This is a pop up', 'Error')
    # messagebox.askquestion('This is a pop up', 'Is this true???')
    # messagebox.askokcancel('This is a pop up', 'Is this ok?')
    # messagebox.askyesno('Pop up', 'Pop up')
    # messagebox.askyesnocancel('Pop up', 'Yes No Cancel')
    # messagebox.askretrycancel('Pop up', '...')
    
    # response = messagebox.showinfo('This is my pop up!', 'My name is Thanos') #returns a string -> ok when you click ok on the pop up
    # Label(root, text = response).pack() 

    # response = messagebox.showwarning('This is my pop up!', 'My name is Thanos') #returns a string -> ok when you click ok on the pop up
    # Label(root, text = response).pack() 

    # response = messagebox.showerror('This is my pop up!', 'My name is Thanos') #returns a string -> ok when you click ok on the pop up
    # Label(root, text = response).pack()

    # response = messagebox.askquestion('This is my pop up!', 'My name is Thanos') #returns a string -> yes or no when you click Yes or No on the pop up
    # Label(root, text = response).pack()
    # if response == 'yes':
    #     Label(root, text = 'You clicked Yes').pack()
    # else:
    #     Label(root, text = 'You clicked No').pack()

    # response = messagebox.askokcancel('This is a pop up', 'Yes or No') #returns 1 when you click Ok or 0 when you click Cancel 
    # Label(root, text = response).pack()
    # if response:
    #     Label(root, text = 'You clicked Ok').pack()
    # else:
    #     Label(root, text = 'You clicked Cancel').pack()

    # response = messagebox.askyesno('This is a pop up', 'Yes or No') #returns 1 when you click Yes and 0 when you click No
    # Label(root, text = response).pack()
    # if response:
    #     Label(root, text = 'You clicked Yes').pack()
    # else:
    #     Label(root, text = 'You clicked No').pack()

    # response = messagebox.askyesnocancel('This is a pop up', 'Yes or No') #returns 1 if you click Yes, 0 if you click No, and None if you click Cancel
    # Label(root, text = response).pack()
    # if response == 1:
    #     Label(root, text = 'You clicked Yes').pack()
    # elif response == 0:
    #     Label(root, text = 'You clicked No').pack()
    # elif response == None:
    #     Label(root, text = 'You clicked Cancel').pack()

    response = messagebox.askretrycancel('This is a pop up', 'Yes or No') #returns 1 if you click Retry, 0 if you click Cancel
    Label(root, text = response).pack()
    if response:
        Label(root, text = 'You clicked Retry').pack()
    else:
        Label(root, text = 'You clicked Cancel').pack()


#main window
root = Tk()
root.title('Message Boxes')

#buttons
button = Button(root, text = 'Pop up!', command = popUp)
button.pack()

#main loop
root.mainloop()