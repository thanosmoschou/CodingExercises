'''
Author: Thanos Moschou
Date: 07/2023
Description: This is a cheatsheet about string methods
The methods that will be shown here are the following:

->bytes
->bytearray
->ord
->chr
->reversed
->any, all
->min, max
->sorted
->map
->join

There are a lot of other methods. Check online for them if needed
'''

#create a string
msg = 'hello' #single or double quotes -> str is an iterative object so you can use it in loops

for let in msg:
    print(let)

print(type(msg))


'''
Types of messages that python supports
'''

print("hello") #normal text
print(u'hello') #unicode string
print(r'hello\n') #raw string -> There are not escape characters such as \n. Now \n is two characters a \ and an n
print(b'hello') #byte string -> this string is the result of bytes function
print(f'hello: {1 + 1}') #format string

#other types of printing text
print("something {0}, {1}".format(1,2))
print("hello %d %d"%(1,2)) #use % inside the string and after string use % and a tuple with values

msg2 = bytes("hello", "utf-8") #bytes(string message, encoding, errors) #errors can be: strict, ignore, replace, xmlcharrefreplace, backslashreplace, namereplace
print(msg2)

msg3 = bytearray("nice", "utf-8", "ignore") #bytearray(string, encoding, errors) -> same arguments like bytes
print(msg3)

#difference between bytes and bytearray: bytearray is mutable while bytes is immutable

print(ord('a'))
print(chr(65))

print(''.join(reversed('thanos')))
#alternative way of reversing a string
print('thanos'[::-1])


print(any(''), any('yo'), all(''), all('thanos')) #any returns false when empty string is given as an argument

#print the min or max letter in a string
print(min('thanos'), max('thanos'))


s = "thanos"
print(sorted(s))
print(''.join(sorted(s)))

#how to use map
#map gets an iterative object and applies the given function to every element of the sequence
print(list(map(int, "123")))

#traverse a string
s = 'hello thanos'
print(s)

for let in s:
    print(let)

print(s[::])
print(s[:4]) #letters at position 0 to 3
print(s[::-1]) #reverse
print(s[:-2]) #until -3 which is three places before the end of the string
#and so on

#how to use join
# string.join(iterative object)
# join will concatenate the string with the elements of the iterative object

print('!'.join('hello')) #join creates a new string where it takes every element of the iterative object following by the given string
#the previous command will take all characters of hello and after every character it will place a !. Keep in mind that it will not put the ! after the last character of the iterative object
#h!e!l!l!o