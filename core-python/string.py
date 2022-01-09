# multiline string
a = """
test (^.^)
+ hello
"""
print(a)

#string is array
a = "hello"
print(a[1])
for char in a:
    print(char)

#substring search
txt = "azad running"
print("azad" in txt)
print("azad" not in txt)

#slice string
print(txt[0:4])

#casing
a = "   namAeWa,hellO  "
print(a.upper())
print(a.lower())
print(a.strip())
print(a.split(","))

#invalid string concat
#a = "tst" + 10
#print(a)

#valid concat
num = 10
a = "tst {}"
print(a.format(num))

# string formatting
# more formatting note: https://www.w3schools.com/python/ref_string_format.asp
txt = "price is {:.2f} dollars"
print(txt.format(45))

# OR
print("hello mr.{}".format("hazrid"))