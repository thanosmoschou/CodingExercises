"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

from random import randint

#We use recursion in order to show the list with reversed order
def showReversedList(list1):
    if len(list1) == 1: #the terminating condition. If the list has only 1 elements remaining, print it and terminate the recursion of this level and finally move 1 level back for the recursion
        print(list1[0], end = ' ')
    else: #we have more elements to print so we pass everytime to the function a smaller list with components from
        print(list1[-1], end = ' ') #the beginning of the list until 1 place before the end(we do not pass to the function the last position element because we are printing it before the call) and move 1 level forward with the recursion
        showReversedList(list1[:-1])

list1 = [randint(0, 10) for x in range(10)]
print(list1)
showReversedList(list1)
print('\n') #this is only for the terminal. I print \n to move the terminal line 1 line down