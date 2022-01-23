/*
A primitive value is a value that has no properties or methods.
A primitive data type is data that has a primitive value.

[primitive list]:
string
number 
    - NaN (this is a typeof number indicate non legal number)
    - Infinity (this is a typeof number Division by 0 (zero) also generates Infinity)
boolean
bigint
symbol
null // cannot contain value
undefined //cannot contain value

Primitive values are immutable (they are hardcoded and therefore cannot be changed) but it may be reassigned.

[primitive object wrapper]:
Except for null and undefined, all primitive values have object equivalents that wrap around the primitive values:

String for the string primitive.
Number for the number primitive.
BigInt for the bigint primitive.
Boolean for the boolean primitive.
Symbol for the symbol primitive.
The wrapper's valueOf() method returns the primitive value.

[complex type]:
function
object

[type of objects]:
Object
Date
Array
String
Number
Boolean

[example]
"Hello"	string	"Hello" is always "Hello"
3.14	number	3.14 is always 3.14
true	boolean	true is always true
false	boolean	false is always false
null	null (object)	null is always null
undefined	undefined	undefined is always undefined
*/

let length1 = 16;                               // Number
let lastName = "Johnson";                      // String
let x = {firstName:"John", lastName:"Doe"};    // Object
let x2; // undefined
let x3 = true // boolean (true|false)
const cars = ["Saab", "Volvo", "BMW"]; // array
let x4 = 12.3


// find type of object
let y = 12
console.log(typeof y)
console.log(typeof x4)

// primitive data type of example
/*
typeof undefined           // undefined
typeof null                // object
null === undefined         // false
null == undefined          // true

typeof "John"              // Returns "string"
typeof 3.14                // Returns "number"
typeof true                // Returns "boolean"
typeof false               // Returns "boolean"
typeof x                   // Returns "undefined" (if x has no value)
*/

// complex data object,function type of example
/*
typeof {name:'John', age:34} // Returns "object"
typeof [1,2,3,4]             // Returns "object" (not "array", see note below will require constructor property)
typeof null                  // Returns "object"
typeof function myFunc(){}   // Returns "function"
*/

//constructor property to check object type example
/*
"John".constructor                // Returns function String()  {[native code]}
(3.14).constructor                // Returns function Number()  {[native code]}
false.constructor                 // Returns function Boolean() {[native code]}
[1,2,3,4].constructor             // Returns function Array()   {[native code]}
{name:'John',age:34}.constructor  // Returns function Object()  {[native code]}
new Date().constructor            // Returns function Date()    {[native code]}
function () {}.constructor        // Returns function Function(){[native code]}
*/

/// convert boolean to number
Number(false)     // returns 0
Number(true)      // returns 1

// convert boolean to string, or use toString()
String(false)      // returns "false"
String(true)       // returns "true"