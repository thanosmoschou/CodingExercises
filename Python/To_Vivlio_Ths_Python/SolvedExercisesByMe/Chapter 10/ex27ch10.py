"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def reverseText(text):
    textRev = ''

    if len(text) == 1:
        textRev += text[0]
    else:
        textRev = text[-1] + ' ' + reverseText(text[:-1])
    
    return textRev

def main():
    message = input('Please enter your message here: ')
    message = message.split() #an grapso sketo message.split() den ginetai i eisagogi se lista kai o tipos paramenei string
    print(reverseText(message))

if __name__ == '__main__':
    main()