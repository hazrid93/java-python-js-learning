# More note here: https://treyhunner.com/2018/03/tuple-unpacking-improves-python-code-readability/

# Python’s multiple assignment looks like this:

x, y = 10, 20
# Here we’re setting x to 10 and y to 20.

# What’s happening at a lower level is that we’re creating a tuple of 10, 20 and then looping over that tuple and taking each of the two items we get from looping and assigning them to x and y in order.

# This syntax might make that a bit more clear:

(x, y) = (10, 20)
# Parenthesis are optional around tuples in Python and they’re also optional in multiple assignment (which uses a tuple-like syntax). All of these are equivalent:

x, y = 10, 20
x, y = (10, 20)
(x, y) = 10, 20
(x, y) = (10, 20)
# Multiple assignment is often called “tuple unpacking” because it’s frequently used with tuples. But we can use multiple assignment with any iterable, not just tuples. Here we’re using it with a list:

x, y = [10, 20]
#x = 10
#y = 20
#And with a string:

x, y = 'hi'
# x = 'h'
# y = 'i'
#Anything that can be looped over can be “unpacked” with tuple unpacking / multiple assignment.

#Here’s another example to demonstrate that multiple assignment works with any number of items and that it works with variables as well as objects we’ve just created:

point = 10, 20, 30
x, y, z = point
print(x, y, z)
#  = 10 20 30
(x, y, z) = (z, y, x)
print(x, y, z)
# = 30 20 10
# Note that on that last line we’re actually swapping variable names, which is something multiple assignment allows us to do easily.