# An iterator is an object that can be iterated upon, meaning that you can traverse through all the values.
# Lists, tuples, dictionaries, and sets are all iterable objects. They are iterable containers which you can get an iterator from.
# All these objects have a iter() method which is used to get an iterator:

# iterator from tuple
from typing import MutableMapping


tuples = ("ali", "abu", "keow")
myIterator = iter(tuples)

print(next(myIterator))
print(next(myIterator))
print(next(myIterator))

# loop through iterator

tuples = ("ali", "abu", "keow")
myIterator2 = iter(tuples)


for x in myIterator2: # The for loop actually creates an iterator object and executes the next() method for each loop.
    print(x)