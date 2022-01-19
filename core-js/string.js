/*

[methods]:
slice(start, end) // extracts a part of a string and returns the extracted part in a new string. (end index not included)
substring(start, end) // same like slice but no negative index supported
substr(start, length) // same like slice but 2nd param is length of extract part (DEPRECATED)
replace() //method replaces a specified value with another value in a string:
toUpperCase() //converted to upper case 
toLowerCase() //converted to lower case
concat() //joins two or more strings
trim() // removes whitespace from both sides of a string (front and back)
padStart() and padEnd() // support padding at the beginning and at the end of a string
indexOf() // find index where the string begin, return -1 if not found, support index to start as 2nd param
lastIndexOf() // search from behind
search() // searches a string for a specified value and returns the position (support regex)
match() //  method searches a string for a match against a regular expression, and returns the matches, as an Array object.
include() //  returns true if a string contains a specified value., 2nd param can be start index value
startsWith() // method returns true if a string begins with a specified value, otherwise false
endsWith() // method returns true if a string ends with a specified value, otherwise false
test() //method is a RegExp expression method. It searches a string for a pattern, and returns true or false, depending on the result.
exec() //method is a RegExp expression method.It searches a string for a specified pattern, and returns the found text as an object. If no match is found, it returns an empty (null) object
 eval() // function evaluates JavaScript code represented as a string. NOT RECOMMEND HIGH RISK
*/



/// escape char with '\'
let text1 = "hello \"world\" here";
console.log(text1)

/// get string length
console.log(text1.length)

/// line break (only for code appearance but it is considered same line)
let text2 = "hello \
world i am blabla"
console.log(text2)

// string object (non primitive) Note: dont use this, unexpected result with == check
let text3 = new String("my name is");
console.log(text3 instanceof String);

// primitive value compare check
let text4 = "test"
let text5 = "test"
console.log(text4 == text5)

// slice example
let sliceText1 = "hellow world my name is hazrid"
console.log(sliceText1.slice(5)) // start from index 5 to end
console.log(sliceText1.slice(-1)) // start from behind if negative

// substring example
console.log(sliceText1.substring(0,6))

// replace() example
let replText = "my name is azad"
replText = replText.replace(/azad/i, "michael") // use regex, 'i' for case insensitive
console.log(replText)

/// indexOf() string search
let idxStr = "Please locate where 'locate' occurs!";
console.log(idxStr.indexOf("locate",2)); // second param for where to start

/// lastIndexOf()
console.log(idxStr.lastIndexOf("Please", 15))// return 0 , start search from behind

/// match() example
let textMatch1 = "The rain in SPAIN stays mainly in the plain";
console.log(textMatch1.match(/ain/g)); // return array with 'g' global search

/// template literal with backtick '`' , support multiline without \
let bckText = `hello whatsup "my" name 'is' whatever`
console.log(bckText)

// template literal substitution with ${}
let firstName = "John";
let lastName = "Doe";

let textLitSub = `Welcome ${firstName}, ${lastName}!`;
console.log(textLitSub)