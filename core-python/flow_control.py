# scope
# if/else
# while/for
# try except (exception)


# local scope
myX = 200 # this will be hidden when calling myFunc
def myFunc():
    myX  = 100
    print(myX)
myFunc()

# calling global scope inside block
myX2 = 200 # this will be hidden when calling myFunc
def myFunc():
    global myX2
    myX2 = 9999 # change global value inside function
    print(myX2)
myFunc()

# creating global scope  variable inside block
def myFunc():
    global myX3
    myX3 = 3333 # change global value inside function

myFunc()
print(myX3)

# basic if
a = 130
b = 10
if b>a:
    print("b greater than a")
elif a==b:
    print("a and b are equal")
else:
    print("none matched")


# shorthand ternary
print("bigger") if a>b else print("smaller")

print("A") if a > b else print("=") if a == b else print("B") #no need for elif in ternary

# logical OR , AND
a = 100
b = 50
c = 500
if a>b and c>a:
    print("both condition satisfied")

# if empty pass
if 1: # truthy
    pass


# while loop with break
i = 1
while i < 5:
    print(i)
    if i == 2:
        break
    i = i + 1

# while loop with continue
jx = 0
while jx < 5:
    jx = jx + 1
    if jx == 2:
        continue    
    print(jx)


# for loop with custom range
for x in range(1, 10):
    if x == 5: #If the loop breaks, the else block is not executed.
        break
    print(x)
else: # to do something when loop ends
    print("ends")


# nested loop
adj = ["red", "big", "tasty"]
fruits = ["apple", "banana", "cherry"]

for x in adj:
  for y in fruits:
    print(x, y)

# try except (exception handling)
try:
    print(xnew)
except:
    print("woops")

# multiple exception
try:
  print(xnew)
except NameError: # a type of exception, exception list : https://www.w3schools.com/python/python_ref_exceptions.asp
  print("Variable x is not defined")
except:
  print("Something else went wrong")

# else block to execute if no error
xnew = 1
try:
    print(xnew)
except:
    print("somethings wrong")
else:
    print("nothings wrong")

# finally block will execute regardless if there is error or not
try:
    print(xnew2)
except:
    print("somethings wrong")
finally:
    print("finally block")

# python raise exception class
xer = 0
if xer>1:
    raise Exception("x must be above 1")


# enumerate , (When you use enumerate(), the function gives you back two loop variables:
# The count of the current iteration
# The value of the item at the current iteration)

enumList = [1,2,3,4,5,6]

for count, value in enumerate(enumList, start=1): # start is optional it is use if we want to start at diff index than 0
    print(count, value)