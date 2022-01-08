# Dictionaries are used to store data values in <key:value> pairs.
# A dictionary is a collection which is ordered*, changeable and do not allow duplicates.

# example dict
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964,
  "year": 2020
}

print(thisdict)

# length of dict
print(len(thisdict))

# accessing key
print(thisdict["brand"])
print(thisdict.get("brand"))

# get keys
x = thisdict.keys()
print(x)

# update dict / for add just use key that doesnt exist it will be added automatically
thisdict["brand"] = "Ferrari"
print(thisdict)

thisdict.update({"brand": "Volkswagen"})
print(thisdict)

# remove item
thisdict.pop("year")
print(thisdict)
thisdict.popitem() # this will remove last item
print(thisdict)

# clear whole dict
thisdict.clear()
print(thisdict)

# loop dict
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964,
  "year": 2020
}

for x in thisdict:
    print(x) # this will print key

for x in thisdict.keys():
    print(x) # this will print key as well

for x in thisdict.values():
    print(x) # this will print values

for x,y in thisdict.items():
    txt = "key: {keyVal}, value: {valVal}"
    print(txt.format( keyVal = x,  valVal = y)) # this will print key value pairs