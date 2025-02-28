'use strict';

var i;

for(i=0; i<10; i++)
{
    console.log(i);
}

var name = "thanos";

console.log(`hello ${name}`);

let arr = [1,2,3,4];
console.log(arr);

//if i change the length property of arr then the length will be changed and some values will be lost(if i make the length smaller)
arr.length = 3;
console.log(arr);

arr.length = 4;
console.log(arr); //now the last place is empty and it does not have the value 4 that had in the past

arr[29]="yo";
console.log(arr);

//create some objects

var human = {
    hName : "thanos",
    hAge : 20,
    printInfo(hName, hAge)
    {
        console.log(`Human Name: ${this.hName}\nHuman Age: ${this.hAge}`);
    }

}

human.printInfo();
//location.replace("https://uom.gr"); //it takes you to this website(redirect)
//document.body.style.backgroundColor = "blue";
console.log(document.querySelector("div > p").nodeName);


