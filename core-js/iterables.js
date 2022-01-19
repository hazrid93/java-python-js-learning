/*
Iterable objects are objects that can be iterated over with for..of.
Technically, iterables must implement the Symbol.iterator method.

The iterator protocol defines how to produce a sequence of values from an object.
An object becomes an iterator when it implements a next() method.
The next() method must return an object with two properties:

    value	The value returned by the iterator (Can be omitted if done is true)
    done	true if the iterator has completed (false if the iterator has produced a new value)

[note about Symbol]
Symbol are always unique per object
Symbols are unique properties on objects. If one creates a symbol and puts it on an object, there's no chance of any other symbol being put on the object and causing bugs due to a name collision.
Using Symbol.iterator as the unique symbol for iterators for potentially any object eliminates the possibility of property collision bugs. 
For example, if .iterator was the (string) property used instead, objects could no longer easily have the .iterator property unless it specifically implemented the iterator protocol.
*/

/// loop over string
for (const x of "hello") {
console.log(x)
}

///loop over array
for (const x of [1,2,3,4,5]) {
console.log(x)
}

/// homemade iterator
function hmyNumbers() {
    let n = 0;
    return {
      next: function() {
        n += 10;
        return {value:n, done:false};
      }
    };
  }
  
  const n = hmyNumbers();
  n.next(); // Returns 10
  n.next(); // Returns 20
  n.next(); // Returns 30

/// proper iterator by implementing Symbol.iterator
let myNumbers = {};

// Make it Iterable, Symbol.iterator method is called automatically by for..of (more on Symbol : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol)
myNumbers[Symbol.iterator] = function() {
  let n = 0;
  let done = false;
  return {
    next() {
      n += 10;
      if (n == 100) {done = true}
      return {
          value:n, 
          done:done};
    }
  };
}

// iterate iterable object , way #1
for (const num of myNumbers) {
    // Any Code Here
  }

// way #2 to iterate
let iterator = myNumbers[Symbol.iterator](); // create iterator
while (true) {
    const result = iterator.next();
    if (result.done) break;
    text += result.value +"<br>";
  }