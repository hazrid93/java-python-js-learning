/*
"use strict"; Defines that JavaScript code should be executed in "strict mode".


[not allowed example]:
x = 3.14;  // This will cause an error
x = {p1:10, p2:20}; // This will cause an error
delete x; // delete variable or function , This will cause an error 
function x(p1, p1) {};   // duplicate  input param ,This will cause an error
Object.defineProperty(obj, "x", {value:0, writable:false}); obj.x = 3.14;   // Writing to a read-only & get-only property is not allowed:
delete Object.prototype; // cannot delete undeletable property, This will cause an error

[note for 'this']:
The this keyword in functions behaves differently in strict mode.
The this keyword refers to the object that called the function.
If the object is not specified, functions in strict mode will return undefined and functions in normal mode will return the global object (window):
*/

console.log()