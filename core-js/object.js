/*
[In JavaScript, almost "everything" is an object].

Booleans can be objects (if defined with the new keyword)
Numbers can be objects (if defined with the new keyword)
Strings can be objects (if defined with the new keyword)
Dates are always objects
Maths are always objects
Regular expressions are always objects
Arrays are always objects
Functions are always objects
Objects are always objects
All JavaScript values, except primitives, are objects.

note:
- assigning method to variable without () means u assign the function definition , if u use () then u are assigning the return value of method
- note on other built in object : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects

[managing object]:
// Create object with an existing object as prototype
Object.create()

// Adding or changing an object property
Object.defineProperty(object, property, descriptor)

// Adding or changing object properties
Object.defineProperties(object, descriptors)

// Accessing Properties
Object.getOwnPropertyDescriptor(object, property)

// Returns all properties as an array
Object.getOwnPropertyNames(object)

// Accessing the prototype
Object.getPrototypeOf(object)

// Returns enumerable properties as an array
Object.keys(object)

[protecting object]:
// Prevents adding properties to an object
Object.preventExtensions(object)

// Returns true if properties can be added to an object
Object.isExtensible(object)

// Prevents changes of object properties (not values)
Object.seal(object)

// Returns true if object is sealed
Object.isSealed(object)

// Prevents any changes to an object
Object.freeze(object)

// Returns true if object is frozen
Object.isFrozen(object)

[metadata of object (can be set with defineProperty)]:
writable : true      //  Specifies if Property value can be changed (strictly to value and not like configurable)
enumerable : true    // Specifies whether the property can be returned in a for/in loop
configurable : true  //  Specifies whether the  property descriptor and existence  can be changed (property's descriptor contains value, enumerable, configurable and writable), basically setting this to false means we cannot modify this property in defineProperty an anymore)
*/

// create object literal

const objLiteral = {
    name: "john",
    age: 12,
    father: "michael"
}

console.log(objLiteral.name)

// create empty object then assign properties
let empObjAndAss = {};
empObjAndAss.name = "ali";

console.log(empObjAndAss.name);

// create object with new keyword
const newObjKeyw = new Object();
newObjKeyw.name = "peter"
console.log(newObjKeyw.name)

// object are mutable  They are addressed by reference(always by value just that new reference object are created), not by value.
const aliMutableTest = {
    age: 12
}

const aliChangerMutTest = aliMutableTest;
aliChangerMutTest.age = 20; // this will change aliMutableTest as well, it didnt create new object
console.log(aliChangerMutTest.age)

// accessing properties
console.log(aliMutableTest['age'])
let ageIs = 'age'
console.log(aliMutableTest[ageIs])

// obj loop (with for loop)
for (let obj in objLiteral){
    console.log("objLiteral key: " + obj);
    console.log("objLiteral val: " + objLiteral[obj]);
}

// delete properties
delete objLiteral.father;
console.log(objLiteral.father == null)

// nested array object
const myObj = {
name: "John",
age: 30,
cars: [
    {name:"Ford", models:["Fiesta", "Focus", "Mustang"]},
    {name:"BMW", models:["320", "X3", "X5"]},
    {name:"Fiat", models:["500", "Panda"]}
]
}
let x;
for (let i in myObj.cars) {
    console.log(i) // array number
    x += "<h1>" + myObj.cars[i].name + "</h1>";
    for (let j in myObj.cars[i].models) {
        x += myObj.cars[i].models[j];
    }
}
console.log(x);

//convert object to array, Json.stringify
const myObjasStr = JSON.stringify(myObj)// can also be use on array to become json array 
const myObjasArr = Object.values(myObj);
console.log(myObjasStr)
console.log(myObjasArr)

// 'get', 'set' can be use on method so the method can be called like property
const personWGet = {
    firstName: "John",
    lastName: "Doe",
    language: "en",
    get lang() {
        return this.language;
    },
    set lang(lang) {
        this.language = lang; // with setter we can assign just with 'personWGet.lang = myr'
    }
  };

console.log(personWGet.lang)// no need () here
  
// set property using defineProperty (rarely used) , to add setter and getter
const obj = {counter : 0};
Object.defineProperty(obj, "reset", {
  get : function () {this.counter = 0;}
});
Object.defineProperty(obj, "increment", {
  get : function () {this.counter++;}
});
Object.defineProperty(obj, "add", {
  set : function (value) {this.counter += value;}
});
obj.reset;
obj.add = 5;
obj.increment;

// changing propertiy with defineProperty
const person1 = {
    firstName: "John",
    lastName : "Doe",
    language : "EN"
  };
  
  // Change a property
  Object.defineProperty(person1, "language", {value : "NO"});
  console.log(person1.language)

  // changing metadata
  Object.defineProperty(person1, "language", {
      value : "NO",
      writeable: true,
      configurable: true,
      enumerable: true
    });

// get all object keys
console.log(Object.keys(person1))

// listing all properties
console.log(Object.getOwnPropertyNames(person1))
