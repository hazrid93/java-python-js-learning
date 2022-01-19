/*
[math constant properties]:
Math.E        // returns Euler's number
Math.PI       // returns PI
Math.SQRT2    // returns the square root of 2
Math.SQRT1_2  // returns the square root of 1/2
Math.LN2      // returns the natural logarithm of 2
Math.LN10     // returns the natural logarithm of 10
Math.LOG2E    // returns base 2 logarithm of E
Math.LOG10E   // returns base 10 logarithm of E

[methods]:

Math.round(x)	Returns x rounded to its nearest integer
Math.ceil(x)	Returns x rounded up to its nearest integer
Math.floor(x)	Returns x rounded down to its nearest integer
Math.trunc(x)	Returns the integer part of x (new in ES6)
Math.sign(x)    returns if x is negative, null or positive:
Math.pow(x, y)  returns the value of x to the power of y:
Math.sqrt(x)    returns the square root of x:
Math.abs(x)     returns the absolute (positive) value of x:
Math.sin(x)     returns the sine (a value between -1 and 1) of the angle x (given in radians).
Math.cos(x)     returns the cosine (a value between -1 and 1) of the angle x (given in radians).
Math.min()       and Math.max() can be used to find the lowest or highest value in a list of arguments:
Math.random()   returns a random number between 0 (inclusive), and 1 (exclusive):
Math.log(x)     returns the natural logarithm of x.
Math.log2(x)    returns the base 2 logarithm of x.
Math.log10(x)   returns the base 10 logarithm of x.
*/

// returns a random number between min and max (both included):
Math.floor(Math.random() * (max - min + 1) ) + min;

// returns a random number between min (included) and max (excluded):
Math.floor(Math.random() * (max - min) ) + min;