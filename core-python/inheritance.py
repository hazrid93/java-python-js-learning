# Inheritance allows us to define a class that inherits all the methods and properties from another class.
# Parent class is the class being inherited from, also called base class.
# Child class is the class that inherits from another class, also called derived class.
# 'self' is required in class method so python can know its a method that belongs in a class


# Use the Person class to create an object, and then execute the printname method:
# in python default and parameterized constructor cannot exist both in the same class
# to make Person able to accept Person() then assign default value to fname and lname
# e.x: def __init__(self, fname = '', lname = '')
class Person:
    # variables stored outside __init__ belong to the class its like static in java, can be refered inside class with self.<varname>
    # changing this value using self.<varname> wont effect other instance of Person but if it is changes by Person.<varname> it will effect
    # all object instance (AVOID THIS UNLESS INTENDED), also if __init__ has object variable with same name as class variable e.x: 'hiddenName' 
    # then any reference by self.hiddenName will use the one by constructor
    hiddenName = "blah!" 
    def __init__(self, fname, lname):
        self.firstname = fname
        self.lastname = lname

    def printname(self):
        print(self.hiddenName)
        print(self.firstname, self.lastname)

    def printWhileEmpty(self):
        print("empty call")

x = Person("John", "Doe")
x.printname()

# create child class without changing constructor
class Student(Person):
    pass # now student has property and method as superclass

y = Student("Mike", "OHearn") # superclass constructor
y.printname()


# create child class while changing constructor

class Student2(Person):
    # this class variable will be shadowed by hiddenName in constructor(instance variable)
    hiddenName = "blah! from child"
    def __init__(self, fname, lname, age, hiddenName):
        Person.__init__(self,fname,lname) # this is like calling super(...) in java child class constructor, can also be 'super().__init__(...)'
        self.age = age
        self.hiddenName = hiddenName

    # override printname method of parent    
    def printname(self):
        print(super().hiddenName) # override shadowing by using super() explicitly
        print(self.hiddenName)
        print(self.firstname, self.lastname, self.age)

y = Student2("Goku", "Kai", 22, "Class variable from __init__ takes precedence") # superclass constructor
y.printname()