// try defining object of type todo
// will gives error if any property of Todo (id,text,done) is not define
var foo = {
    id: 1,
    text: ''
    //done: true //compiler will complain
};
// using Todo type inside function argument
// input is Todo type, return is also Todo type
function toggleTodo(todo) {
    return {
        id: todo.id,
        text: todo.text,
        done: !todo.done
    };
}
var argument = {
    id: 1,
    text: '…',
    done: true
};
// note dont do like this, always return new object and not 
function toggleTodoBad(todo) {
    todo.done = !todo.done; // bad because we are changing argument object
    return todo;
}
console.log('Before toggleTodo(), argument is:');
console.log(argument); //{ done: true, id: 1, text: '…' }
toggleTodoBad(argument);
console.log('After toggleTodo(), argument is:');
console.log(argument); // { done: false, id: 1, text: '…' }
//Todo 2 is equivalent to
/*
note:
In TypeScript, if you use the Readonly<...> keyword on an object type,
it makes all of its properties readonly. This is often easier than manually adding readonly to every property.

type Todo2 = Readonly<{
    id: number,
    text: string,
    done: boolean
}>

or

type Foo = {
    bar: number
}

type ReadonlyFoo = Readonly<Foo> // wrap existing type into read only type

note:
keywords like Readonly<...> are called mapped types.
Mapped types are kind of like functions, except
the input/output are TypeScript types.

There are many built-in mapped types (like Required<...>, Partial<...>, etc).
*/
// try redefine toggleTodoBad again using Todo2 
function toggleTodoBad2(todo) {
    todo.done = !todo.done; // compiler will warn about assigning new value
    return todo;
}
//# sourceMappingURL=2.js.map