/*
In JavaScript all functions are object methods.
If a function is not a method of a JavaScript object, it is a function of the global object.

[other type of built in constructor]
new String()    // A new String object
new Number()    // A new Number object
new Boolean()   // A new Boolean object
new Object()    // A new Object object
new Array()     // A new Array object
new RegExp()    // A new RegExp object
new Function()  // A new Function object
new Date()      // A new Date object

however most of the time better to use primitive .. e.x:
Use string literals "" instead of new String().
Use number literals 50 instead of new Number().
Use boolean literals true / false instead of new Boolean().
Use object literals {} instead of new Object().
Use array literals [] instead of new Array().
Use pattern literals /()/ instead of new RegExp().
Use function expressions () {} instead of new Function().
*/

/// general function
let x = myFunction(4, 3);   // Function is called, return value will end up in x

function myFunction(a, b) {
    let x2 = "tests"; // this become local variable only belong to this function
  return a * b; // Function returns the product of a and b
}

console.log(x)

/// create new function using js generic Function() constructor (rarely used)
const myFunctionGen = new Function("a", "b", "return a * b");
let xmyFunctionGen = myFunctionGen(4, 3);

/// lambda function
let xLam = () => {
    return (2*4)
}
console.log(xLam());

/// Immediate invoke expression (IIE)
let xIee = (function() {
    console.log("whats up")
    return "whats up"
}())
console.log(xIee)

/// function declaration are hoisted above, (function expression are not)
hoistmyFunction(5);

function hoistmyFunction(y) {
  return y * y;
}

/// get function argument length, with default
function fucnArgLength(a, b = 5) {
    console.log(arguments.length, b)
    return;
}
fucnArgLength(1);

/// print typeof function
if(typeof fucnArgLength == 'function'){ 
    console.log(typeof fucnArgLength)
}

/// using this inside function definite will be global object
let xglobal = xglobalFunc(); // x will be the window object

function xglobalFunc() {
  console.log(this) // will be undefined since not running under DOM
}


/// invoke function from object (function expression)
// In a function definition, this refers to the "owner" of the function.
// In the example above, this is the person object that "owns" the fullName function.
// In other words, this.firstName means the firstName property of this object.
const myObject = {
    firstName:"John",
    lastName: "Doe",
    fullName: function () {
     console.log(this.firstName + " " + this.lastName); // 'this' will belong to myobject
    }
  }
  myObject.fullName();  

/// invoke function from object (arrow function)
console.log(this) //check current this type
let personGb = {
name: 'Jim',
sayName: (obj) => {
    console.log(obj.name)
    //console.log(this === undefined); // true,  'this' will not belong to the object but rather the one calling fullname() method. (should be window but this js is not runned inside html)
}
};

personGb.sayName(personGb); // object instance need to be passed manually
  


/// function constructor (creating object using function),  creates a new object. The new object inherits the properties and methods from its constructor.
// In a constructor function this does not have a value. It is a substitute for the new object. The value of this will become the new object when a new object is created
function MyFunctionConst(arg1, arg2) {
    this.firstName = arg1;
    this.lastName  = arg2;
  }

const myObj1 = new MyFunctionConst("John", "Doe");
const myObj2 = new MyFunctionConst("Xav", "Re");
console.log(myObj1.firstName);
//adding property or method to object wont add it to other object
myObj1.age = 12; // this wont add to myObj2
  
/// using call() method,  invoke (call) a method with an owner object as an argument (parameter).
// calls the fullName method of person, using it on person1:
const person = {
    fullName: function(city, country) {
      return this.firstName + " " + this.lastName + ", " + city + ", " + country;
    }
  }
  const person1 = {
    firstName:"John",
    lastName: "Doe"
  }
  const person2 = {
    firstName:"Mary",
    lastName: "Doe"
  }
  
  /// This will return "John Doe", use person1 as the 'this' owner
  console.log(person.fullName.call(person1, "shah alam", "malaysia"));
  // apply() method is the same except it takes array
  console.log(person.fullName.apply(person1, ["Oslo", "Norway"]));

  /// closure, nested functions have access to the scope "above" them.
  // makes it possible for a function to have "private" variables. counter is protected by the scope of the anonymous function, and can only be changed using the add function.
  const add = (function () {
    let counter = 0;
    return function () { // this will be return to add to become add(), with counter = 0 initially and only reachable by this method
        counter += 1; 
        console.log(counter)
    }
  })();
  
  add();
  add();
  add();

  /// function prototype
  function PersonTestProto(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;
  }
  
  const myFather = new PersonTestProto("John", "Doe", 50, "blue");
  const myMother = new PersonTestProto("Sally", "Rally", 48, "green");

  //PersonTestProto.father = "michael" Note: not valid cannot add to function constructor like this must ass to constructor definition itself
  PersonTestProto.prototype.nationality = "English"; // valid way to add to function constructor by using prototype
  PersonTestProto.prototype.name = function() {
    return this.firstName + " " + this.lastName;
  };

  console.log(myFather.nationality)


  /// generator function (Generators are functions that can be exited and later re-entered. Their context (variable bindings) will be saved across re-entrances.)
  // more note: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function*
  function* generator(i) {
    yield i;
    yield i + 10;
  }
  
  const gen = generator(10);
  
  console.log(gen.next().value);
  // expected output: 10
  
  console.log(gen.next().value);
  // expected output: 20