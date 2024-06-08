"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple radio buttons with GUI in Python
"""       

from tkinter import *
from PIL import ImageTk, Image

#create functionality for the radiobuttons
def clicked(value):
    myLabel = Label(root, text = value)
    myLabel.pack()

#main window
root = Tk()
root.title('Simple radio buttons...')

modes = [('Pepperoni', 'Pepperoni'), ('Cheese', 'Cheese'), ('Mushroom', 'Mushroom'), ('Onion', 'Onion')]
pizza = StringVar()
pizza.set('Pepperoni')

for text, mode in modes:
    Radiobutton(root, text = text, variable = pizza, value = mode).pack(anchor = W) #place it to the west
# valueSelection = IntVar() #tkinter variable...it could be StringVar or anything depends on variable on Radiobutton
# #on kinter variables we can set and get things...notice that when we set things it selects automatically a radio button depends on the value on Radiobutton
# #valueSelection.get()
# valueSelection.set('2')

#create radio buttons
# Radiobutton(root, text = 'Option 1', variable = valueSelection, value = 1, command = lambda : clicked(valueSelection.get())).pack()
# Radiobutton(root, text = 'Option 2', variable = valueSelection, value = 2, command = lambda: clicked(valueSelection.get())).pack()

# myLabel = Label(root, text = pizza.get())
# myLabel.pack()

#buttons
myButton = Button(root, text = 'Click me!', command = lambda: clicked(pizza.get()))
myButton.pack()

#main loop
root.mainloop()