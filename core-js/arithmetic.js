/*

JavaScript has only one type of number. Numbers can be written with or without decimals.
JavaScript Numbers are Always 64-bit Floating Point
Unlike many other programming languages, JavaScript does not define different types of numbers, like integers, short, long, floating-point etc.
JavaScript numbers are always stored as double precision floating point numbers

+	Addition
-	Subtraction
*	Multiplication
**	Exponentiation (ES2016)
/	Division
%	Modulus (Remainder)
++	Increment
--	Decrement

[methods]:
toString() // return int as string
toExponential() // returns a string, with a number rounded and written using exponential notation.
toFixed() // returns a string, with the number written with a specified number of decimals: e.x: 9.656 -> toFixed(3) -> 9.656
toPrecision() // method returns a string, with a number written with a specified length: e.x: 9.656 -> toPrecision(3) -> 9.66
valueOf() // convert number to number and object to number (use to convert Number object to primitive)
parseFloat() // parses a string and returns a number. Spaces are allowed. Only the first number is returned:
parseInt() // parses a string and returns a whole number. Spaces are allowed. Only the first number is returned:
Number() // can be used to convert JavaScript variables to number, can also convert a date to a number.

[Number properties]:
MAX_VALUE	Returns the largest number possible in JavaScript, e.x: Number.MAX_VALUE
MIN_VALUE	Returns the smallest number possible in JavaScript
POSITIVE_INFINITY	Represents infinity (returned on overflow)
NEGATIVE_INFINITY	Represents negative infinity (returned on overflow)
NaN	Represents a "Not-a-Number" value


*/

///exponential 
let ex1 = 123e5;    // 12300000
let ex2 = 123e-5;   // 0.00123

/// decimal number
let decNum1 = 3.14

///floating arithmetic not accurate so need multiply and divide
let arix1 = (0.2 * 10 + 0.1 * 10) / 10; // 0.3
console.log(arix1)

// floating arithmetic if didnt multiply and divide
let arix2 = 0.2 + 0.1; // 0.30000000000000004
console.log(arix2)

// adding string and number will end up as string
let x1 = "12"
let x3 = 21
console.log(x1+x3)

/// NaN example if invalid
console.log(100/"appe")

// check if isNan()
let nanEx1 = 12/"appl";
console.log(isNaN(nanEx1)) // true

/// Infinity example
console.log(2/0)

/// using Number() constructor , NOTE: dont use create unexpected behaviour (with == or === comparison)
let yC = new Number(123);

// toString() , return int as string or use this method: String(<numberhere>)
let xStr = 1222
console.log(xStr.toString())