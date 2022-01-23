
/// callback is a function passed as an argument to another function.
function funcCall1(name){
    console.log(name);
}

function funcMain1(age, callback){
    callback(age + ",ali")
}

console.log(funcMain1("abu",funcCall1))