"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

def func1(f): #decorator
    def htmlTags(): #this is available only from components of func1 or with decoration
        text = f()
        textTag = ''
        for item in text:
            if item == '.':
                textTag = textTag + item + '<p>'
            else:
                textTag += item

        return textTag
    return htmlTags

@func1
def func3(): #function for decoration
    message = input('Enter a message with dots: ')
    return message

def main():
    print(func3())
    return

if __name__ == '__main__':
    main()
