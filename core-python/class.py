# for class and object
# The self parameter is a reference to the current instance of the class, and is used to access variables that belongs to the class.
# (similar to 'this' in java/js)  and only used within the class definition

# create class
class Fruit:
    x = 1

p1 = Fruit()
print(p1.x)

# class with __init__ (this is a constructor), 
# Note that '__<name>__' means override class method or default python object method. 
# in this case we are overriding default __init__() constructor for class. 

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    def myFunc(self):
        print("my name is : " + self.name)

person = Person("Ali", 32)
print(person.name)
print(person.age)
person.myFunc()

# modify obj property
person.name = "Abu"
person.myFunc()

# delete obj property
del person.name

# empty class
class Cat:
    pass # use pass to avoid syntax error