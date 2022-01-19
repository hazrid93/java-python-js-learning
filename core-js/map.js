/*
A Map holds key-value pairs where the keys can be any datatype.
A Map remembers the original insertion order of the keys.
A Map has a property that represents the size of the map.
Object can be use as key

Note that all method that return iterator object can use next() method until reach undefined (last)

[methods]
new Map()	Creates a new Map object
set()	    Sets the value for a key in a Map
get()	    Gets the value for a key in a Map
clear()	    Removes all the elements from a Map
delete()	Removes a Map element specified by a key
has()	    Returns true if a key exists in a Map
forEach()	Invokes a callback for each key/value pair in a Map
entries()	Returns an iterator object with the [key, value] pairs in a Map
keys()	    Returns an iterator object with the keys in a Map
values()	Returns an iterator object of the values in a Map
Property	Description
size	    Returns the number of Map elements
*/

/// create a map
const fruits = new Map([
    ["apples", 500],
    ["bananas", 300],
    ["oranges", 200]
  ]);

/// Set Map Values
fruits.set("durian", 500);

/// get from map
console.log(fruits.get("apples"))

/// get size
console.log(fruits.size)

///delete item from map
fruits.delete("apples");

/// check if map has item key (boolean)
console.log(fruits.has("apples"))

///maps are object
console.log(typeof fruits)
console.log(fruits instanceof Map)

/// loop map with forEach
let text = "";
fruits.forEach (function(value, key) {
  text += key + ' = ' + value;
})
console.log(text)

// loop map with keys()
let veggies = "";
for (const x of fruits.keys()) {
  veggies += x;
}
console.log(veggies)

// loop with values
// Sum all values
let total = 0;
for (const x of fruits.values()) {
  total += x;
}
console.log(total)

// list all entries() as [key,value]
let textentries = "";
for (const [x,y] of fruits.entries()) {
  textentries += x + "," + y;
}
console.log(textentries)