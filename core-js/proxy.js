//The Proxy object enables you to create a proxy for another object, 
//which can intercept and redefine fundamental operations for that object.
/*
Proxy is created with two parameters:
target: the original object which you want to proxy
handler: an object that defines which operations will be intercepted and how to redefine intercepted operations.

note: Proxy objects allow you to define get or set traps,
which run a function when you attempt to get or set any property to the proxy.
The receiver is provided as an argument of that function. 
The receiver will usually the Proxy object itself, or an object which inherits from it.

more not about proxy/receiver here: https://blog.sessionstack.com/how-javascript-works-proxy-and-reflect-11748452c695#:~:text=The%20Proxy%20object%20allows%20developers,in%20between%20for%20fundamental%20operations.&text=Reflect%20on%20the%20other%20hand,JavaScript%20operations%20that%20are%20interceptable.
*/

/// example1
const target = {
    message1: "hello",
    message2: "everyone"
  };
  
  const handler1 = {};
  
  const proxy1 = new Proxy(target, handler1);
  console.log(proxy1.message1)

/// proxy with modification
const target2 = {
    message1: "hello",
    message2: "everyone"
  };
  //get() handler, which intercepts attempts to access properties in the target.
  const handler2 = {
      get: function(target, prop, receiver){// (target object, name of property, proxy or objet that inherit from proxy)
          if(prop === 'message1'){
              return "HELLO";
          }
          // argument object is an Array-like object accessible inside functions that contains the values of the arguments passed to that function.
          // need this for those that doesnt match 'prop === xxx'. if not it would be undefined
          return Reflect.get(...arguments); 
      }
  };
  
  const proxy2 = new Proxy(target, handler2);
  console.log(proxy2.message1)
  console.log(proxy2.message2)


//Proxy with get handler and receiver
let x = {p: 1, foo: 2};
let y = {foo: 3};

let obj = new Proxy(x, {
  get(t, prop, receiver) {
    return receiver[prop] + 'bar'
  }
})
console.log(Reflect.get(obj, 'foo', y)) // "3bar"
