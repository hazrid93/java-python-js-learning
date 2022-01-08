# Set are used to store multiple items in a single variable.
# unordered and data is unchangeable (Set items are unchangeable, but you can remove items and add new items.)
# duplicate are not allowed (will be ignored)
# item are not indexed


mySet = {"apple", "durian", "watermelon"}
print(mySet)

# length of set
print(len(mySet))

# using set constructor
set2 = set(("apple", "banana"))
print(set2)

# print set
for i in mySet:
    print(i)

# check if item exist
print("apple" in mySet)

# add item
mySet.add("orange")
print(mySet)

# add another set
mySet.update(set2)
print(mySet)

# remove item
mySet.remove("apple")
print(mySet)