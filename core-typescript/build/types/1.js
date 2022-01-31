//function without type
function toggleTodo(todo) {
    return {
        // if id is not defined here then return will be wrong, this can be solved with type or interface
        //id: todo.id, 
        text: todo.text,
        done: !todo.done
    };
}
var dummy1 = { id: 1, text: 'First todo', done: false };
var dummy2 = { id: 2, text: 'Second todo', done: false };
var togglereturn1 = toggleTodo(dummy1);
console.log(togglereturn1);
//# sourceMappingURL=1.js.map