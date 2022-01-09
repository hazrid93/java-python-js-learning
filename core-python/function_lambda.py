# function & lambda (small anonymous function)

# defining a function
def defFunc():
    print("my default function")
defFunc()

# func with argument
def defFArg(name):
    print(name + " is my name.")

defFArg("hazrid")

# dynamic argument, argument will pass as list
def defFArg2(*name):
    for x in name:
        print(x + " is my name.")
defFArg2("hazrid", "azad", "shaharudin")

# passing argument via key and not order
def defFArg3(age, name):
    print(name + " is my name, " + str(age) + " is my age." )
defFArg3(name = "hazrid", age = 12)

# dynamic argument via key , argument will pass as dict
def defFArg2(**child):
    for x in child.keys():
        print(child[x] + " is my name.")
defFArg2(name = "hazrid", age = "12", lastName = "shaharudin") 

# default argument value (if not passed)
def defaultArg(age = 12):
    print("age is " + str(age))
defaultArg()

# use pass for empty func
def emptyFunc():
    pass

emptyFunc()

# recursion example
def tri_recursion(k):
  if(k > 0):
    # res = 6 + (5 + (4 + (3 + (2 + (1))))) <-- after reaching  k = 0 it will return and
    # traverse back from top to bottom (while executing from 6 to 1 its building up stack of instruction)
    result = k + tri_recursion(k - 1) 
    print(result)
  else:
    result = 0
  return result

print("\n\nRecursion Example Results")
tri_recursion(6)


# fibonacci recursion example
# fib = 0,1,1,2,3,5 :x means iteration of fibonacci '3' here is the 3rd as an example excluding 0,1
result = []
def fibonacci(x, y):
    # print fibonacci until reaching close to 100
    if(x >= 0 and y < 500 ):
        result.append(fibonacci(y, x+y))
        print(result)
    else:
        return 
    return y

print("\n\nFibonacci Example Results")
fibonacci(0,1)
result.pop(0)
result.sort()
result.insert(0, 0)
result.insert(1, 1)
print(result)


# lambda simple
x = lambda a : a + 10 # anonymous function x , takes 'a' as input and return 'a + 10'
print(x(5))

# lambda multi input
x = lambda a,b,c : a + b + c
print(x(1,2,3))

# return lambda from function definition
def myFunc(n):
    return lambda a: a * n

myMultiplier = myFunc(5) # return myFunc with n set to 5
print(myMultiplier(5));