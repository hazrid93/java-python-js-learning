# Numbers Class
The object of the wrapper class contains or wraps its respective primitive data type. Converting primitive data types into object is called boxing, and this is taken care by the compiler. Therefore, while using a wrapper class you just need to pass the value of the primitive data type to the constructor of the Wrapper class.

And the Wrapper object will be converted back to a primitive data type, and this process is called unboxing. The Number class is part of the java.lang package.

example:
```
int i = 5000;
float gpa = 13.65f;
double mask = 125;
```

## Methods
```
Sr.No.	Method & Description
1	    xxxValue() (e.x: intValue, doubleValue, floatValue, shortValue)
        Converts the value of this Number object to the xxx data type and returns it.

2	    compareTo()
        Compares this Number object to the argument.

3	    equals()
        Determines whether this number object is equal to the argument.

4	    valueOf()
        Returns an Integer object holding the value of the specified primitive.

5	    toString()
        Returns a String object representing the value of a specified int or Integer.

6	    parseInt()
        This method is used to get the primitive data type of a certain String.

7	    abs()
        Returns the absolute value of the argument.

8	    ceil()
        Returns the smallest integer that is greater than or equal to the argument. Returned as a double.

9	    floor()
        Returns the largest integer that is less than or equal to the argument. Returned as a double.

10	    rint()
        Returns the integer that is closest in value to the argument. Returned as a double.

11	    round()
        Returns the closest long or int, as indicated by the method's return type to the argument.

12	    min()
        Returns the smaller of the two arguments.

13	    max()
        Returns the larger of the two arguments.

14	    exp()
        Returns the base of the natural logarithms, e, to the power of the argument.

15	    log()
        Returns the natural logarithm of the argument.

16	    pow()
        Returns the value of the first argument raised to the power of the second argument.

17	    sqrt()
        Returns the square root of the argument.

18	    random()
        Returns a random number.
```