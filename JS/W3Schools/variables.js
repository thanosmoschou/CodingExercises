/*
What’s the difference between using let and var in JavaScript?

The Solution
The keywords let and var both declare new variables in JavaScript. The difference between let and var is in the scope of the variables they create:

Variables declared by let are only available inside the block where they’re defined.
Variables declared by var are available throughout the function in which they’re declared.
Consider the difference between these two JavaScript functions:

function varScoping() {
  var x = 1;

  if (true) {
    var x = 2;
    console.log(x); // will print 2
  }

  console.log(x); // will print 2
}

function letScoping() {
  let x = 1;

  if (true) {
    let x = 2;
    console.log(x); // will print 2
  }

  console.log(x); // will print 1
}
In varScoping(), one x variable is used throughout the function, even though an x variable is declared in two different places with different values.

In letScoping(), two distinct x variables are used – one appears in the main function body and another in the if block. This behavior remains the same if we replace the first let keyword with a var keyword:

function varAndLetScoping() {
  var x = 1;

  if (true) {
    let x = 2;
    console.log(x); // will print 2
  }

  console.log(x); // will print 1
}
A var variable will be available thoroughout the function body in which it is defined, no matter how deeply nested its definition. A let variable will only be available within the same block where it is defined. See below:

function nestedScopeTest() {
  if (true) {
    var functionVariable = 1;
    let blockVariable = 2;

    console.log(functionVariable); // will print 1
    console.log(blockVariable); // will print 2

    if (true) {
      console.log(functionVariable); // will print 1
      console.log(blockVariable); // will print 2
    }
  }

  console.log(functionVariable); // will print 1
  console.log(blockVariable); // will throw an error
}
This works because the var declaration of functionVariable is hoisted to the top level of nestedScopeTest() before execution, but the let declaration of blockVariable is not.

The behavior of var can be useful in some cases, but is quite different from other programming languages, and can cause difficult-to-resolve bugs. The more recently introduced let keyword allows for more precise and predictable variable scoping, and allows programmers to safely reuse names for temporary variables within the same function.

One final point to note is that when working outside of function bodies, at a global level, let does not create a property on the global object, whereas var does. Therefore:

// Global variables
var x = 1;
let y = 2;
console.log(this.x); // will print 1
console.log(this.y); // will print undefined


Re-Declaring JavaScript Variables
If you re-declare a JavaScript variable declared with var, it will not lose its value.

Note
You cannot re-declare a variable declared with let or const.

This will not work:

let carName = "Volvo";
let carName;

Note
If you put a number in quotes, the rest of the numbers will be treated as strings, and concatenated.

JavaScript Dollar Sign $
Since JavaScript treats a dollar sign as a letter, identifiers containing $ are valid variable names:

Example
let $ = "Hello World";
let $$$ = 2;
let $myMoney = 5;


JavaScript Underscore (_)
Since JavaScript treats underscore as a letter, identifiers containing _ are valid variable names:

Example
let _lastName = "Johnson";
let _x = 2;
let _100 = 5;
Using the underscore is not very common in JavaScript, but a convention among professional programmers is to use it as an alias for "private (hidden)" variables.


The let keyword was introduced in ES6 (2015).

Variables defined with let can not be redeclared.

Variables defined with let must be declared before use.

Variables defined with let have block scope.

Cannot be Redeclared
Variables defined with let can not be redeclared.

You can not accidentally redeclare a variable declared with let.

With let you can not do this:

let x = "John Doe";

let x = 0;
With var you can:

var x = "John Doe";

var x = 0;
Block Scope
Before ES6 (2015), JavaScript had Global Scope and Function Scope.

ES6 introduced two important new JavaScript keywords: let and const.

These two keywords provide Block Scope in JavaScript.

Variables declared inside a { } block cannot be accessed from outside the block:

Example
{
  let x = 2;
}
// x can NOT be used here
Variables declared with the var keyword can NOT have block scope.

Variables declared inside a { } block can be accessed from outside the block.

Example
{
  var x = 2;
}
// x CAN be used here
Redeclaring Variables
Redeclaring a variable using the var keyword can impose problems.

Redeclaring a variable inside a block will also redeclare the variable outside the block:

Example
var x = 10;
// Here x is 10

{
var x = 2;
// Here x is 2
}

// Here x is 2
Redeclaring a variable using the let keyword can solve this problem.

Redeclaring a variable inside a block will not redeclare the variable outside the block:

Example
let x = 10;
// Here x is 10

{
let x = 2;
// Here x is 2
}

// Here x is 10


Redeclaring
Redeclaring a JavaScript variable with var is allowed anywhere in a program:

Example
var x = 2;
// Now x is 2

var x = 3;
// Now x is 3


With let, redeclaring a variable in the same block is NOT allowed:

Example
var x = 2;   // Allowed
let x = 3;   // Not allowed

{
let x = 2;   // Allowed
let x = 3;   // Not allowed
}

{
let x = 2;   // Allowed
var x = 3;   // Not allowed
}
Redeclaring a variable with let, in another block, IS allowed:

Example
let x = 2;   // Allowed

{
let x = 3;   // Allowed
}

{
let x = 4;    // Allowed
}
Let Hoisting
Variables defined with var are hoisted to the top and can be initialized at any time.

Meaning: You can use the variable before it is declared:

Example
This is OK:

carName = "Volvo";
var carName;
If you want to learn more about hoisting, study the chapter JavaScript Hoisting.

Variables defined with let are also hoisted to the top of the block, but not initialized.

Meaning: Using a let variable before it is declared will result in a ReferenceError:

Example
carName = "Saab";
let carName = "Volvo";



The const keyword was introduced in ES6 (2015).

Variables defined with const cannot be Redeclared.

Variables defined with const cannot be Reassigned.

Variables defined with const have Block Scope.

Cannot be Reassigned
A const variable cannot be reassigned:

Example
const PI = 3.141592653589793;
PI = 3.14;      // This will give an error
PI = PI + 10;   // This will also give an error
Must be Assigned
JavaScript const variables must be assigned a value when they are declared:

Correct
const PI = 3.14159265359;
Incorrect
const PI;
PI = 3.14159265359;
When to use JavaScript const?
Always declare a variable with const when you know that the value should not be changed.

Use const when you declare:

A new Array
A new Object
A new Function
A new RegExp
Constant Objects and Arrays
The keyword const is a little misleading.

It does not define a constant value. It defines a constant reference to a value.

Because of this you can NOT:

Reassign a constant value
Reassign a constant array
Reassign a constant object
But you CAN:

Change the elements of constant array
Change the properties of constant object
Constant Arrays
You can change the elements of a constant array:

Example
// You can create a constant array:
const cars = ["Saab", "Volvo", "BMW"];

// You can change an element:
cars[0] = "Toyota";

// You can add an element:
cars.push("Audi");
But you can NOT reassign the array:

Example
const cars = ["Saab", "Volvo", "BMW"];

cars = ["Toyota", "Volvo", "Audi"];    // ERROR
Constant Objects
You can change the properties of a constant object:

Example
// You can create a const object:
const car = {type:"Fiat", model:"500", color:"white"};

// You can change a property:
car.color = "red";

// You can add a property:
car.owner = "Johnson";
But you can NOT reassign the object:

Example
const car = {type:"Fiat", model:"500", color:"white"};

car = {type:"Volvo", model:"EX60", color:"red"};    // ERROR


Block Scope
Declaring a variable with const is similar to let when it comes to Block Scope.

The x declared in the block, in this example, is not the same as the x declared outside the block:

Example
const x = 10;
// Here x is 10

{
const x = 2;
// Here x is 2
}

// Here x is 10
You can learn more about block scope in the chapter JavaScript Scope.

Redeclaring
Redeclaring a JavaScript var variable is allowed anywhere in a program:

Example
var x = 2;     // Allowed
var x = 3;     // Allowed
x = 4;         // Allowed
Redeclaring an existing var or let variable to const, in the same scope, is not allowed:

Example
var x = 2;     // Allowed
const x = 2;   // Not allowed

{
let x = 2;     // Allowed
const x = 2;   // Not allowed
}

{
const x = 2;   // Allowed
const x = 2;   // Not allowed
}
Reassigning an existing const variable, in the same scope, is not allowed:

Example
const x = 2;     // Allowed
x = 2;           // Not allowed
var x = 2;       // Not allowed
let x = 2;       // Not allowed
const x = 2;     // Not allowed

{
  const x = 2;   // Allowed
  x = 2;         // Not allowed
  var x = 2;     // Not allowed
  let x = 2;     // Not allowed
  const x = 2;   // Not allowed
}
Redeclaring a variable with const, in another scope, or in another block, is allowed:

Example
const x = 2;       // Allowed

{
  const x = 3;   // Allowed
}

{
  const x = 4;   // Allowed
}
Hoisting
Variables defined with var are hoisted to the top and can be initialized at any time.

Meaning: You can use the variable before it is declared:

Example
This is OK:

carName = "Volvo";
var carName;
If you want to learn more about hoisting, study the chapter JavaScript Hoisting.

Variables defined with const are also hoisted to the top, but not initialized.

Meaning: Using a const variable before it is declared will result in a ReferenceError:

Example
alert (carName);
const carName = "Volvo";


*/