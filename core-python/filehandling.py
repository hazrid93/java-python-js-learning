"""
There are four different methods (modes) for opening a file:

"r" - Read - Default value. Opens a file for reading, error if the file does not exist

"a" - Append - Opens a file for appending, creates the file if it does not exist

"w" - Write - Opens a file for writing, creates the file if it does not exist

"x" - Create - Creates the specified file, returns an error if the file exists

In addition you can specify if the file should be handled as binary or text mode

"t" - Text - Default value. Text mode

"b" - Binary - Binary mode (e.g. images)
"""

import os

## File reading
file = open("./files/Pandas/data.csv")
print(file.read()) # read whole
file.close() # close file to avoid issue, to apply changes that are in buffer

file2 = open("./files/Pandas/data.csv")
print(file2.readline()) # read one line

for x in file2:
    print(x) # read line by line
file2.close()


## File creation/write/delete

xfile = open("tempfile.txt", "w") # x for creating only, use 'w' to create only if not exist
xfile.write("add one line")
xfile.close()

xfileOpen = open("tempfile.txt", "r")
print(xfileOpen.read())
xfileOpen.close()

# remove file if exist
if os.path.exists("tempfile.txt"):
    os.remove("tempfile.txt")
else:
    print("file not exist")


