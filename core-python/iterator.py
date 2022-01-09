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

# custom class by default doesnt have iterator, this can be implemented manually
# this example will loop forever if use 'for x in myiter'
class MyNumbers:
  def __iter__(self):
    self.a = 1
    return self

  def __next__(self):
    x = self.a
    self.a += 1
    return x

myclass = MyNumbers()
myiter = iter(myclass)

print(next(myiter))
print(next(myiter))
print(next(myiter))
print(next(myiter))
print(next(myiter))

# this example is to add a stopping mechanism to the iter if using 'for x in myiter'
class MyNumbers2:
  def __iter__(self):
    self.a = 1
    return self

  def __next__(self):
    if self.a <= 20:
      x = self.a
      self.a += 1
      return x
    else:
      raise StopIteration

myclass2 = MyNumbers2()
myiter2 = iter(myclass2)

for x in myiter2:
  print(x)