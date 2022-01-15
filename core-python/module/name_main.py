'''
note from: https://www.freecodecamp.org/news/if-name-main-python-example/

Python files are called modules and they are identified by the .py file extension. A module can define functions, classes, and variables.

So when the interpreter runs a module, the __name__ variable will be set as  __main__ if the module that is being run is the main program.

But if the code is importing the module from another module, then the __name__  variable will be set to that module’s name.

Let's take a look at an example. Create a Python module named file_one.py and paste this top level code inside:

# Python file one module

print("File one __name__ is set to: {}" .format(__name__))
file_one.py
By running this file you will see exactly what we were talking about. The variable __name__ for this module is set to __main__:

File one __name__ is set to: __main__
Now add another file named file_two.py and paste this code inside:

# Python module to import

print("File two __name__ is set to: {}" .format(__name__))
file_two.py
Also, modify the code in file_one.py like this so we import the file_two module:

# Python module to execute
import file_two

print("File one __name__ is set to: {}" .format(__name__))
file_one.py
Running our file_one code once again will show that the __name__ variable in the file_one did not change, and still remains set to __main__. But now the variable __name__ in file_two is set as its module name, hence file_two.

The result should look like this:

File two __name__ is set to: file_two
File one __name__ is set to: __main__
But run file_two directly and you will see that its name is set to __main__:

File two __name__ is set to: __main__

The variable __name__ for the file/module that is run will be always __main__. But the __name__ variable for all other modules that are being imported will be set to their module's name.
'''

# example of to check if __name__ is __main__
if __name__ == "__main__":
   #Do something here
   pass