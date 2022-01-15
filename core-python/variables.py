'''
#Python data types:

Text Type:	str
Numeric Types:	int, float, complex
Sequence Types:	list, tuple, range
Mapping Type:	dict
Set Types:	set, frozenset
Boolean Type:	bool
Binary Types:	bytes, bytearray, memoryview

'''

import random
# print val
x = "3"
print(x)

# print type
x = "100"
print(type(int(x)))

# assingning multiple variable
names = ["ali","abu"]
x, y = names
print(x + " " + y)

# function scoping
z = "outside function"
def myFunc():
    z = "inside function"
    print(z)

myFunc()
print(z);


# random
print(random.randrange(1,10))
