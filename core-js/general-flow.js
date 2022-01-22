

/// if condition
let x1 = 12;

if(x1 = 12){
    console.log("if")
} else if(x1 = 0){
    console.log("else if")
} else {
    console.log("else")
}

/// switch condition
// if the break statement removed, the next case will be executed even if the evaluation does not match the case.
let x2 = 24;
switch(x2){
    case 12:
        console.log("case1");
        break;
    case 24:
        console.log("case2");
        break;
    default: // default is not mandatory
        console.log("default")
}

/// for loop
//  using var, the variable declared in the loop redeclares the variable outside the loop.
// using let, the variable declared in the loop does not redeclare the variable outside the loop.
// When let is used to declare the i variable in a loop, the i variable will only be visible within the loop.
let text1 = [1,2,3,4,5]
for(let i = 0; i< text1.length; i++){
    console.log(text1[i])
    if(i === 2) {
        break;
    }
}

/// for loop if initial value set outside
let i = 2;
let len = text1.length;
let text3 = "";
for (; i < len; i++) {
  text3 += text1[i] + "<br>";
}
console.log(text3)

/// for in (for in might not respect order sequence)
const person = {fname:"John", lname:"Doe", age:25};

let text5 = "";
for (let x in person) {
    text5 += person[x];
}
console.log(text5);


/// arrays.foreach()
const numbers1 = [223,123,43,54];
let txt6 = "";
//function takes 3 arguments: (The item value,The item index,The array itself)
numbers1.forEach(myFunction);
function myFunction(value, index, array){
    txt6 = txt6 + value;
}
console.log(txt6)

// for of (loop over iterable data structures such as Arrays, Strings, Maps, NodeLists, and more)
const cars2 = ["BMW", "Volvo", "Mini"];

let text7 = "";
for (let x of cars2) {
  text7 += x;
}
console.log(text7)

// while
while (i < 10) {
    if(cars2[i] != null){
        console.log(cars2[i])
    }
    i++;
  }

// try catch
try {
    console.log("trytest");
    throw new Error("error")
} catch (err){
    console.error("error in: " + err);
}finally{
    console.log("finallyhit!");
}