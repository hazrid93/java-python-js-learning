
/// arr length
let fruits1 = ['apple', 'banana'];
console.log(fruits1.length)

// get last item
console.log(fruits1[fruits1.length -1])

//add item to array
fruits1.push('durian');

// loop over array
fruits1.forEach((item,index,array)=> {
    console.log(item,index);
})

// remove and return last item
let lfruit1 = fruits1.pop();
console.log(lfruit1);

// remove item at beginning of array and return
let ffruit1 = fruits1.shift();
console.log(ffruit1);

// add item at beginning of array
fruits1.unshift('strawberry', 'chocolate', 'pisang', 'soursop', 'whatever')
console.log(fruits1)

// remove item at index
fruits1.splice(1,2)// (start at, number of item to remove)
console.log(fruits1)

// get keys of array
console.log(Object.keys(fruits1))

// loop using keys
for(let i in Object.keys(fruits1)){
    console.log([fruits1[i]])
}