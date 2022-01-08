# Lists are used to store multiple items in a single variable.
# order and data is changeable
# duplicate are allowed
# item are indexed 0->..

# print list
listz = ["apple", "banana", "durian"]
print(listz)

# list type
print(type(listz))

# list length
print(len(listz))

# other way to create list using constructor
listx = list(("a", "b","c"))
print(listx)

# access item
print(listx[1])

# negative index
print(listx[-1]) #access last item

# get range of list
print(listx[0:2])

# check if item exist
if "a" in listx:
    print("\"a\" exist")

# add into list at index
listx.insert(2, "d")
print(listx)

# add item at end 
listx.append("e")
print(listx)

# append list to another list , can also add other object type list set, dict, tupl
listc = ["f", "g"]
listx.extend(listc)
print(listx)

# remove specific item
listx.remove('g')
print(listx)

# remove specific index (will remove last index if not specified)
listx.pop(0)
print(listx)


# loop list
i = 0
while i < len(listx):
    print(listx[i])
    i =i+1

# sort list
listx.sort() # alphabetically(case sensitive by default) or numerically by default
print(listx)
listx.sort(reverse = True) # reverse sort
print(listx)
listx.sort(key = str.lower) # alphabetically not case sensitive 
print(listx)

# custom sort function

def sorter(n):
    return n > 5

listNew = [1,0,20,44,3,4,5,99,77,45,32,23,18]
listNew.sort(key = sorter)
print(listNew)

# clear list content
listx.clear()
print(listx)