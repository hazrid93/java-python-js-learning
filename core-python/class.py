# for class and object
# The self parameter is a reference to the current instance of the class, and is used to access variables that belongs to the class.
# (similar to 'this' in java/js)  and only used within the class definition

# python special methods: https://python.plainenglish.io/special-methods-that-will-change-how-you-build-classes-in-python-cd0226b52eb6, http://exampleprogramming.com/specialvars.html

# create class
class Fruit:
    # this is class variable shared by all instance of this object, changing this will effect all object
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

# print all class methods
print(dir(Person))

# static and class method, more at : https://realpython.com/instance-class-and-static-methods-demystified/
# We generally use class method to create factory methods. Factory methods return class objects ( similar to a constructor ) for different use cases., We generally use static methods to create utility functions.
'''@staticmethod : 
A static method is also a method that is bound to the class and not the object of the class.
A static method can’t access or modify the class state.
'''

'''@classmethod
A class method is a method that is bound to the class and not the object of the class.
They have the access to the state of the class as it takes a class parameter that points to the class and not the object instance.
It can modify a class state that would apply across all the instances of the class. For example, it can modify a class variable that will be applicable to all the instance
'''
from datetime import date


class Personx:
    def __init__(self, name, age):
        self.name = name
        self.age = age
      
    # a class method to create a Person object by birth year.
    @classmethod
    def fromBirthYear(cls, name, year):
        return cls(name, date.today().year - year)
      
    # a static method to check if a Person is adult or not.
    @staticmethod
    def isAdult(age):
        return age > 18
  
person1 = Personx('mayank', 21)
person2 = Personx.fromBirthYear('mayank', 1996)
  
print (person1.age)
print (person2.age)
  
# print the result
print (Personx.isAdult(22))
