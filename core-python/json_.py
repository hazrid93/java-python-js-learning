import json

# convert json string to dict
xe = '{ "name":"John", "age":30, "city":"New York"}'
print(xe)

ye = json.loads(xe)

for x,y in ye.items():
    print(x,y)


# convert dict to json

ze = json.dumps(ye)
print(ze)