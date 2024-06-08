
/*
Creating an Array
Using an array literal is the easiest way to create a JavaScript Array.

Syntax:

const array_name = [item1, item2, ...];    

*/

const ar = ["thanos", "elena", "furkan"];
console.log(typeof ar);

document.getElementById("a").innerHTML = ar.toString();

const b = ["thanos", "moschou"];

function my(value)
{
    console.log(value);
}

b.forEach(my); //The forEach() method calls a function (a callback function) once for each array element.