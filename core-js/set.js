/*
A JavaScript Set is a collection of unique values.
Each value can only occur once in a Set.
A Set can hold any value of any data type.

Note that all method that return iterator object can use next() method until reach undefined (last)

[methods]:
new Set()	Creates a new Set
add()	    Adds a new element to the Set
delete()	Removes an element from a Set
has()	    Returns true if a value exists
clear()	    Removes all elements from a Set
forEach()	Invokes a callback for each element
values()	Returns an Iterator with all the values in a Set
keys()	    Same as values()
entries()	Returns an Iterator with the [value,value] pairs from a Set
Property	Description
size	    Returns the number elements in a Set
*/

/// create a new set
const letters = new Set(["a","b","c"]);

// Add Values to the Set
letters.add("f");
letters.add("d");
letters.add("e");

// loop set
let text = ''
letters.forEach (function(value) {
    text += value;
})
console.log(text)

// values() method to return iterator object, note key() method return same stuff because set has no key
let myIterator = letters.values()
console.log(myIterator)
// use iterator to loop
let text2 = "";
for (const entry of myIterator) {
  text2 += entry;
}
console.log(text2)

// entries() returns [value,value] pairs instead of [key,value] pairs.

let myentries = letters.entries()
let text3 = '';
for (const [x,y] of myentries) {
    text3 += x + ", " + y;
}
console.log(text3)

// set are object type
console.log(typeof letters)
console.log(letters instanceof Set)
