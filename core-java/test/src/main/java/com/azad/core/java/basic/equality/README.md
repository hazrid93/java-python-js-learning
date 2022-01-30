# Equality comparison

## Be aware of autoboxing/unboxing
Because the compiler does this behind the scenes, we must be sure to compare primitives, or wrapper objects, thanks to Integer/Long caching.

To be 100% sure, we could use Comparable<T>#compareTo(T) of the wrapper types instead, which always uses the encapsulated value, and not the object reference.

## Primitive
Primitives are literals, fixed values in memory, that can be tested for equality with ==.
Except when they can’t.
In contrast to the other primitive data types, the floating-point data types float and double can’t reliably be checked for equality with ==, due to their storage method in memory. They aren’t exact values:

 we can compare the values of primitives with the <, >, <=, and >=operator.

[example1]
```
float value = 1.0f;
value += 0.1f;      // 1.1f
value += 0.1f;      // 1.2f
value += 0.1f;      // 1.3000001f

boolean isEqual = (value == 1.3f) // false
```

We’ve got two options to deal with this. Either by using java.util.BigDecimal, which is exact. Or by using threshold-based comparisons:

[example2]
```
float value = 1.0f;
value += 0.1f;      // 1.1f
value += 0.1f;      // 1.2f
value += 0.1f;      // 1.3000001f

float THRESHOLD = 0.00001f;
boolean isEqual = Math.abs(value - 1.3f) < THRESHOLD); // true
```

Note: some discussion at [link](https://stackoverflow.com/questions/3832592/test-for-floating-point-equality-fe-floating-point-equality)

## objects
If you compare objects with ==, it will also compare the value of the object. The only problem here is that the value of an object is actually its reference, hence the name object reference type.
This means two values are only equal if they point to the same object in memory.
In practice, variables might be equal in some cases, but not in others:

[example1]
```
String a = "a";
String b = "b";
String ab = "ab";

boolean result1 = (a == "a");      // true
boolean result2 = (ab == "ab");    // true
boolean result3 = (a + b == "ab"); // false
```

Another “not so obvious” pitfall can happen with primitive wrapper types:

```
Integer a = 127;
Integer b = 127;
Integer c = 128;
Integer d = 128;
boolean equal      = (a == b); // true
boolean notEqual   = (c == d); // false
boolean equalAgain = (new Integer(128) == 128); // true
```
Happens because...
The valueOf(...) methods of java.util.Integer and java.util.Long actually cache values for specific ranges (-128 to 127), making a and b the same object, but not cand d. And thanks to unboxing, equalAgain is true.
Therefore for Object comparison even for rapper its better to use .equals() . However becareful that the class not using default Object.equals() since it only check object reference like '==', in this case its better to override both the equals() and hashcode(). (Hash code: Equal objects must have the same hash code.)


To compare object types we need to implement the interface java.lang.Comparable<T> with its single method int compareTo(T).
The result of left.compareTo(right) is supposed to be the following:

```
Result | Meaning / Order
--------|---------------------------
   0    | left is the same as right
  -1    | left < right
   1    | left > right
```

Note: more discussion at [link](https://belief-driven-design.com/equality-and-comparison-in-java-a5e0f05b808/)

# Conclusion
- when deciding between equals() or compareTo() refer class implementation which is recommended.
- be careful with wrapper class autoboxing quirks like Integer caching -128 ~ 127
- always implement equals and hashcode if needed
- never compare objects with ==
- dont compare float with ==