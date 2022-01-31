/*
assigned numeric values when they are stored. The first value always takes the numeric value of 0, 
while the other values in the enum are incremented by 1.
*/
enum PrintMedia {
    Newspaper = 0,
    Newsletter = 2,
    Magazine = 1,
    Book = "Hello"
}

// ways to get enum value or name
console.log(PrintMedia["Magazine"]);
PrintMedia.Magazine;   // returns  3
PrintMedia["Magazine"];// returns  3
PrintMedia[3];         // returns  Magazine (the name of enum) possible by reverse mapping


/*
{ '0': 'Newspaper',
  '1': 'Newsletter',
  '2': 'Magazine',
  '3': 'Book',
  Book: 3,
  Magazine: 2,
  Newsletter: 1,
  Newspaper: 0 }
*/
console.log(PrintMedia)

// assigning manual enum values 
enum FruitPrice {
    Apple = 12,
    Banana = 24
}

let value : FruitPrice = FruitPrice.Apple;
console.log(value)

// string enum