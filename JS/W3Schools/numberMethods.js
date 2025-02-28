'use strict';

let num = "1";


console.log(typeof num)
num = Number(num); //convert js variables to numbers
console.log(num, typeof num);

//parseInt() parses a string and returns a whole number. Spaces are allowed. Only the first number is returned

let num2 = "-10";
console.log(num2, typeof num2);
num2 = parseInt(num2); //convert string to number...If the number cannot be converted, NaN (Not a Number) is returned
console.log(num2, typeof num2);

let num3 = "10 20 30";
console.log(num3, typeof num3);

num3 = parseFloat(num3);
console.log(num3, typeof num3);

let num4 = "10.30";
console.log(num4, typeof num4);
num4 = parseFloat(num4);
console.log(num4, typeof num4);

let n = 5;
console.log(Number.isInteger(n));