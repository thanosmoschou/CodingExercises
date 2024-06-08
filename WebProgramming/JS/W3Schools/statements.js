'use strict';

/*
JavaScript Programs

A computer program is a list of "instructions" to be "executed" by a computer.
In a programming language, these programming instructions are called statements.
A JavaScript program is a list of programming statements.
In HTML, JavaScript programs are executed by the web browser.

JavaScript Statements

JavaScript statements are composed of:
Values, Operators, Expressions, Keywords, and Comments.

This statement tells the browser to write "Hello Dolly." inside an HTML element with id="demo":

Example
document.getElementById("demo").innerHTML = "Hello Dolly.";

Most JavaScript programs contain many JavaScript statements.
The statements are executed, one by one, in the same order as they are written.

Semicolons ;
Semicolons separate JavaScript statements.
Add a semicolon at the end of each executable statement

When separated by semicolons, multiple statements on one line are allowed:
a = 5; b = 6; c = a + b;

JavaScript ignores multiple spaces. You can add white space to your script to make it more readable.

The following lines are equivalent:
let person = "Hege";
let person="Hege";

A good practice is to put spaces around operators ( = + - * / ):

let x = y + z;

JavaScript Code Blocks
JavaScript statements can be grouped together in code blocks, inside curly brackets {...}.

The purpose of code blocks is to define statements to be executed together.

One place you will find statements grouped together in blocks, is in JavaScript functions:

Example
function myFunction() {
  document.getElementById("demo1").innerHTML = "Hello Dolly!";
  document.getElementById("demo2").innerHTML = "How are you?";
}

Some keywords
Keyword	        Description
var	            Declares a variable
let	            Declares a block variable
const	        Declares a block constant
if	            Marks a block of statements to be executed on a condition
switch	        Marks a block of statements to be executed in different cases
for         	Marks a block of statements to be executed in a loop
function	    Declares a function
return	        Exits a function
try	            Implements error handling to a block of statements

JavaScript keywords are reserved words. Reserved words cannot be used as names for variables.

JavaScript Expressions
An expression is a combination of values, variables, and operators, which computes to a value.

The computation is called an evaluation.

For example, 5 * 10 evaluates to 50

Statement is something that is gonna be executed and will not return anything. Expression will return a value.

*/


let a, b, c;
a = 1;
b = 2;
c = 3;

console.log(a + b);

