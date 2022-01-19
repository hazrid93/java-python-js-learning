/*
there are three type of var
1.var : 
- no block scope
- declaration are hoisted and other code can refer to var before it was assign (will default to undefined)
- also JavaScript only hoists declarations, not initializations.
- can be redeclared
2.let : 
- respect block scope
- cannot be redeclared
- must be Declared before use.
3.const : 
- cannot be updated
- cannot be redeclared
- respect block scope
- cannot be Reassigned (act as java 'final').

TLDR: just use let and const
*/

// example of var hoisting
x = 5;
console.log(x);
var x;
