"""
Author: Thanos Moschou
Date: 09/2022
Description: Simple GUI Calculator with Python
"""

from tkinter import *

#create the basic window

root = Tk() #otan ftiaxneis pragmata me tkinter to proto poy tha grafeis einai ayto. Einai to parathiro mou
root.title('Simple Calculator')

#create the input field of the screen

entr = Entry(root, width = 35, borderwidth = 5) #thelo to input box na einai sto root
entr.grid(row = 0, column = 0, columnspan = 3, padx = 10, pady = 10)
#columnspan = 3 giati kato apo to pedio eisodou exo 3 buttons kai kathe button antistixei se 1 stili
#kai thelo to pedio na einai iso mikos me ta 3 buttons sto sunolo

#make the functionalities

def button_click(number):
    current = entr.get() #pairno oti exei idi to parathiro
    entr.delete(0, END) #svino oti eixe to pedio mesa
    entr.insert(0, str(current) + str(number)) #grafo auto pou patithike
    return

def button_clrScreen():
    entr.delete(0, END) #svino oti eixe to pedio mesa
    return
    
def button_add():
    first_num = entr.get()
    global f_num #kathe fora pou patas + dimiourgeitai nea f_num kai pairnei oti noumero eixe i othoni
    global math

    f_num = int(first_num)
    math = 'Add'    
    entr.delete(0, END)
    return

def button_subtract():
    first_num = entr.get()
    global f_num #kathe fora pou patas + dimiourgeitai nea f_num kai pairnei oti noumero eixe i othoni
    global math

    f_num = int(first_num)
    math = 'Sub'  
    entr.delete(0, END)
    return

def button_multiply():
    first_num = entr.get()
    global f_num #kathe fora pou patas + dimiourgeitai nea f_num kai pairnei oti noumero eixe i othoni
    global math

    f_num = int(first_num)
    math = 'Mul'  
    entr.delete(0, END)
    return

def button_divide():
    first_num = entr.get()
    global f_num #kathe fora pou patas + dimiourgeitai nea f_num kai pairnei oti noumero eixe i othoni
    global math

    f_num = int(first_num)
    math = 'Div'  
    entr.delete(0, END)
    return

def button_equal():
    second_num = entr.get() #pairno ton deutero arithmo 
    entr.delete(0, END)
    
    if math == 'Add':
        entr.insert(0, f_num + int(second_num))
    elif math == 'Sub':
        entr.insert(0, f_num - int(second_num))
    elif math == 'Mul':
        entr.insert(0, f_num * int(second_num))
    elif math == 'Div':
        entr.insert(0, f_num / int(second_num))

    return

#define buttons

button1 = Button(root, text = '1', padx = 40, pady = 20, command = lambda : button_click(1), bg = 'Black', fg = 'White')
button2 = Button(root, text = '2', padx = 40, pady = 20, command = lambda : button_click(2), bg = 'Black', fg = 'White')
button3 = Button(root, text = '3', padx = 40, pady = 20, command = lambda : button_click(3), bg = 'Black', fg = 'White')
button4 = Button(root, text = '4', padx = 40, pady = 20, command = lambda : button_click(4), bg = 'Black', fg = 'White')
button5 = Button(root, text = '5', padx = 40, pady = 20, command = lambda : button_click(5), bg = 'Black', fg = 'White')
button6 = Button(root, text = '6', padx = 40, pady = 20, command = lambda : button_click(6), bg = 'Black', fg = 'White')
button7 = Button(root, text = '7', padx = 40, pady = 20, command = lambda : button_click(7), bg = 'Black', fg = 'White')
button8 = Button(root, text = '8', padx = 40, pady = 20, command = lambda : button_click(8), bg = 'Black', fg = 'White')
button9 = Button(root, text = '9', padx = 40, pady = 20, command = lambda : button_click(9), bg = 'Black', fg = 'White')
button0 = Button(root, text = '0', padx = 40, pady = 20, command = lambda : button_click(0), bg = 'Black', fg = 'White')
buttonAdd = Button(root, text = '+', padx = 39, pady = 20, command = button_add, bg = 'Black', fg = 'White')
buttonSubtract = Button(root, text = '-', padx = 41, pady = 20, command = button_subtract, bg = 'Black', fg = 'White')
buttonMultiply = Button(root, text = '*', padx = 40, pady = 20, command = button_multiply, bg = 'Black', fg = 'White')
buttonDivide = Button(root, text = '/', padx = 41, pady = 20, command = button_divide, bg = 'Black', fg = 'White')
buttonEqual = Button(root, text = '=', padx = 90, pady = 20, command = button_equal, bg = 'Black', fg = 'White')
buttonClear = Button(root, text = 'Clear', padx = 79, pady = 20, command = lambda : button_clrScreen(), bg = 'Black', fg = 'White')

#put buttons in the screen

button1.grid(row = 3, column = 0)
button2.grid(row = 3, column = 1)
button3.grid(row = 3, column = 2)

button4.grid(row = 2, column = 0)
button5.grid(row = 2, column = 1)
button6.grid(row = 2, column = 2)

button7.grid(row = 1, column = 0)
button8.grid(row = 1, column = 1)
button9.grid(row = 1, column = 2)

button0.grid(row = 4, column = 0)
buttonClear.grid(row = 4, column = 1, columnspan = 2)
buttonAdd.grid(row = 5, column = 0)
buttonEqual.grid(row = 5, column = 1, columnspan = 2)

buttonSubtract.grid(row = 6, column = 0)
buttonMultiply.grid(row = 6, column = 1)
buttonDivide.grid(row = 6, column = 2)

#create the main loop of the program
root.mainloop()
