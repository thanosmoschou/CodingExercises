"""
Author: Thanos Moschou
Date: 08/2023
Description: This is a cheatsheet about how to manipulate files in python.
"""


#There are 2 types of files: Text and binary.
#All the methods that are available for text files are also for binary files. 
#You need to be careful about how you manipulate these type of files


#Read from a text file. You can use context manager or do the following:

print("READING FROM A TEXT FILE")

print("CASE 1")
f = open('file.txt', 'r') #If you do not provide the mode, rt which means read text will be the default value (Actually you can skip t if you want to read text file just like I did here)
content = f.read()
print(content)
f.close() #Close the file in order to avoid file corruption or data loss

#open() will create a file object

#This is good but we need to provide some error handling because file may not exist
print("CASE 2")

try:
    f = open('file.txt')
except FileNotFoundError:
    print('File does not exist.')
else:
    content = f.read() 
    print(content)
    f.close()

#You can also have this alternative:

print("CASE 3")

try:
    f = open('file.txt')
    content = f.read() 
    print(content)
    f.close()
except FileNotFoundError:
    print('File does not exist.')


#read() method can have an agrument
#For example read(4) will read the following 4 characters (or bytes because each character is 1 byte) from the text file
#If an argument is not specified, it will read all the file contents

print("CASE 4")

f = open('file.txt', 'r') 
content = f.read(4)
print(content)

#You can use seek() method to change the position of the file pointer inside the file
f.seek(0)

#readline() method will read the following line
print("CASE 5")

print(f.readline(), end='')
f.seek(0)

#Each file object has a built in iterator. That means I can use the object in loops

print("CASE 6")

for line in f: #In each loop, the next line of the file is returned and is stored in line variable
    print(line, end='') #I skip the \n of the print because I already have \n in the lines

#or this
f.seek(0)

print("CASE 7")

print(f) #print the first line of the file
try:
    while True:
        print(next(f), end='') #use next in order to get the next line of the file (which is the next value of the iterator object)
except StopIteration:
    print('End of file')

#or this
f.seek(0)

print("CASE 8")

line = f.readline()
print(line, end='')
while line:
    line = f.readline() #If we reach the EOF, readline will return an empty string
    print(line, end='')


#readlines() will return a list that contains all the lines of the file as elements

f.seek(0)

print("CASE 9")
lines = f.readlines()
print(lines)
f.close()


#Using a context manager

print("CASE 10")
with open('file.txt', 'r') as filename:
    #Use a method from all that we have learned 
    lines = filename.readlines()
    print(lines)

#By using context managers I do not have to worry about error handling or if I closed the file and I not have to wrap my code inside a try except block of code.

#Write to a file. You can use a context manager or do the following

print("WRITING TO A TEXT FILE")

print("CASE 1")

#if the file does not exist, it will be created but if it exists, all its contents will be deleted
f = open('output.txt', 'w')
f.write('Hello' + '\n') #write methods needs a string so if you want to enter numbers, make sure you converted them to string. Also write does not add \n
f.close()


#writelines()
#This method is the opposite of readlines(). It gets a list of lines (that must have the \n inside them because writelines does not add it) and it writes the lines to the file
print("CASE 2")

#I will use context manager for this one (I could also do it with the previous method)
lines = ['hello\n', 'My name is thanos\n']
with open('output.txt', 'w') as filename: #The previous contents are deleted. If I enter append mode it will not delete any of file contents
    filename.writelines(lines)


print("CASE 3")
with open('output.txt', 'a') as filename:
    filename.writelines(lines)



#Writing to a binary file.
#Now I need to convert everything to bytes. I can use bytes or bytearray functions. Do the following or use a context manager instead

print("CASE 1")

f = open('binary.bin', 'wb')
msg = 'hello\n'
f.write(bytearray(msg, encoding='ascii'))
f.write(bytes(msg, encoding='ascii'))
f.close()

#Note that I cannot enter the string to the binary file as it is. It need to be converted to bytes. I used both bytearray and bytes

print("CASE 2")
f = open('binary.bin', 'ab')
numbers = [1,2,3,4]
f.write(bytearray(numbers)) #or bytes
f.close()

print("CASE 3")
lines = ['thanos\n', 'eleni\n']
lines = [bytes(sen, encoding='ascii') for sen in lines]
with open('binary.bin', 'ab') as filename:
    filename.writelines(lines)


#Read from a binary file. Everything is returned as a byte sequence

#read()
print("CASE 1")
f = open("binary.bin", "rb") 
msg = f.read() #This will read all file contents just like it does with text files. If a parameter specified it will return the specified amount of bytes
print(msg)

f.seek(0)

#readline()
print("CASE 2")
msg = f.readline() #Read a line. 
print(msg) #I need to convert this because it is bytes

f.seek(0)

#I can use loops as I did with text files
print("CASE 3")
for msg in f:
    print(msg)


f.seek(0)

print("CASE 4")

msg = f.readline()
print(msg)
while msg:
    msg = f.readline()
    print(msg)

#Just like text files, readline will return an empty string if it reaches the end of file
#I can use the try except loop I did with text files as well

f.seek(0)

#readlines()
print("CASE 5")
msg = f.readlines() #this will return a list of all the elements that file contains. It works the same as it does in text files
print(msg)

#Convert the elements of the file
#I know that msg has a string in its first position
print(msg[0].decode(encoding='ascii')) #str function will not work

#I know that it has a list in its 3rd position
print(list(msg[2])) #This will also print the ascii characters of thanos and \n because the list and these characters are in the same line of the file (we used readlines and it returned a list of the file lines)




