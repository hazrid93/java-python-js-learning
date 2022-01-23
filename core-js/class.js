/*
more note at : 
(prototype) https://developer.mozilla.org/en-US/docs/Web/JavaScript/Inheritance_and_the_prototype_chain
(constructor) https://dmitripavlutin.com/understanding-constructor-property/#:~:text=The%20constructor%20property%20in%20a,to%20reference%20the%20constructor%20function.&text=Because%20properties%20are%20inherited%20from,on%20the%20instance%20object%20too.&text=Even%20if%20the%20object%20is,inherits%20the%20constructor%20from%20Object.
(object.create) https://medium.com/@lancelyao/object-create-vs-new-in-javascript-8315327bdc5a

Classes are a template for creating objects. 
They encapsulate data with code to work on that data. 
Classes in JS are built on prototypes but also have some syntax and semantics 
that are not shared with ES5 class-like semantics.
*/

/*
[more about static]
for function constructor static is just property added not on prototype but 
object directly. e.x: 

function Person() { }
Person.greetStatic = function() { return 'Static hello!' }
Person.prototype.greetInstance = function () { return 'Hello!' };

let p1 = new Person();
console.log(p1.greetInstance()) 
console.log(Person.greetStatic()) 

Note: adding on  prototype is When you define a function 
it has a  prototype that is used as the [[prototype]] of all of the objects it creates using the new keyword. 
When you add members to Example.prototype, all objects created using new Example() 
will be able to read the member as if they had it (through their [[prototype]], namely Example.prototype).
On the other hand, if you assign members to Example directly, you can only access them through Example itself
*/

/*
[to get class name of object]:
There's no exact counterpart to Java's getClass() in JavaScript. Mostly that's due to JavaScript being 
a prototype-based language, as opposed to Java being a class-based one.
Depending on what you need getClass() for, there are several options in JavaScript:

typeof
instanceof
obj.constructor
func.prototype, proto.isPrototypeOf
A few examples:

function Foo() {}
var foo = new Foo();
typeof Foo;             // == "function"
typeof foo;             // == "object"

foo instanceof Foo;     // == true
//use this if object
foo.constructor.name;   // == "Foo"
//use this if Class
Foo.name                // == "Foo"   

Foo.prototype.isPrototypeOf(foo);   // == true
Foo.prototype.bar = function (x) {return x+x;};
foo.bar(21);            // == 42
*/

/*
[to get list of object property]:
The Object.getOwnPropertyNames(obj) method returns only the properties of the obj (like length).
 You can use Object.getPrototypeOf(obj) to get a more complete list of methods/properties.

 [checking inheritance]:
 Document.prototype.__proto__ === Node.prototype // warning __proto__ is deprecated, use Object.getPrototype instead:
using '.constructor' will return strictly the instance of class, this has more accuracy than 'instanceof' because this one return true for extended one as well 

[checking inheritance-Object.prototype way]:
 class Foo {}

class Bar extends Foo {}
class Baz extends Bar {}

const foo = new Foo();
const bar = new Bar();
const baz = new Baz();

// For this function:
// - level 0 is self
// - level 1 is parent
// - level 2 is grandparent
// and so on.
function getPrototypeAt(level, obj) {
    let proto = Object.getPrototypeOf(obj);
    while (level--) proto = Object.getPrototypeOf(proto);
    return proto;
}

console.log("bar is a foo:", bar instanceof Foo); // bar is a foo: true
console.log("baz is a foo:", baz instanceof Foo); // baz is a foo: true
console.log("foo is exactly a foo:", getPrototypeAt(0, foo) === Foo.prototype); // foo is exactly a foo: true
console.log("bar is exactly a foo:", getPrototypeAt(0, bar) === Foo.prototype); // bar is exactly a foo: false
console.log("bar is direct child of foo:", getPrototypeAt(1, bar) === Foo.prototype); // bar is direct child of foo: true
console.log("baz is direct child of foo:", getPrototypeAt(1, baz) === Foo.prototype); // baz is direct child of foo: false
console.log("baz is direct child of bar:", getPrototypeAt(1, baz) === Bar.prototype); // baz is direct child of bar: true
console.log("baz is grandchild of foo:", getPrototypeAt(2, baz) === Foo.prototype); // baz is grandchild of foo: true
*/

/// class creation functions
class Test1 {

    //static properties
    // static public field exist per class
    static prop1 = 'prop1';
    //private static properties
    static #prop2; 

    // non static public class field exist per object. it behave like field in constructor
    // but field outside constructor initialized first before constructor is finished
    // basically same as this.friend = friend inside constructor but doesnt get input from constructor( we can assign input from constructor but then its redundant to define outside constructor in that way)
    friend = "ali"; //public class field

    // private field must exist outside constructor definition
    #friend22 = "abu";//private field
    constructor(name, age, ...siblings) {
        this.name = name;
        this.age = age;
        this.siblings = siblings;
    }

    // getter example
    get area() {
        return "shah alam, " + this.friend;
    }

    //method 
    upperName() {
        return this.name.toUpperCase();
    }

    //generator function
    * getSiblings() {
        for (let sibling of this.siblings) {
            yield sibling;
        }
    }
}

Test1.girl = "alice"; // this is equivalent to static girl , property definition inside class
Test1.prototype.girl1 = "aliceXz" // this is like instance property

let objT1 = new Test1("azad", 28, "sib1", "sib2", "sib3");
console.log(Test1.girl) // alice
console.log(Test1.girl1) // undefined
console.log(objT1.girl1) // alicexz
console.log(objT1.name)
console.log(objT1.friend)
console.log(objT1.area)
console.log(objT1.upperName())
console.log(Test1.prop1)
console.log(...objT1.getSiblings());
let xxx = objT1.getSiblings();
for (let x of xxx) {
    console.log(x);
}

// extend Test1
class Test2 extends Test1 {
    constructor(name, age, ...siblings){
        super(name, age, ...siblings);
    }

    bark(){
        return "barking...";
    }
}

let test2x = new Test2("azad", 28, "sib1", "sib2", "sib3");
console.log(test2x)

// class extend function constructor
function Animal1 (name) {
    this.name = name;
  }
  
  Animal1.prototype.speak = function () {
    console.log(`${this.name} makes a noise.`);
  }
  
  class Dog1 extends Animal1 {
    speak() {
      console.log(`${this.name} barks.`);
    }
  }
  
  let d = new Dog1('Mitzie');
  d.speak(); // Mitzie barks.
  

  /// class cannot extend from regular object, if want to need to use
  // Object.setPrototypeOf() 
  const Animal2 = {
    friend: 'alu',
    speak() {
      console.log(`${this.name} makes a noise.`);
    }
  };
  // not directly extend object Animal2
  class Dog2 {
    age = 12;
    constructor(name) {
      this.name = name;
    }

    speak(){
        super.speak(); // call super of same method
    }
  }
  
  // If you do not do this you will get a TypeError when you invoke speak
  Object.setPrototypeOf(Dog2.prototype, Animal2);
  let d2 = new Dog2('Mitzie');
  
  console.log(Object.values(d2));
  d2.speak(); // Mitzie makes a noise.