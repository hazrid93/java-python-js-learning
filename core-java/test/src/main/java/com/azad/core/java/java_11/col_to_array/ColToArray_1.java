package com.azad.core.java.java_11.col_to_array;

import java.util.Arrays;
import java.util.List;

//Java 11 introduced an easy way to convert a collection to an array.
public class ColToArray_1 {
    public static void main(String[] args) {
        // asList() to turn array into list
        List<String> namesList = Arrays.asList("Joe", "Julie");
        // Old way
        // toArray() to turnlist into array
        String[] names = namesList.toArray(new String[namesList.size()]);
        System.out.println(names.length);
        // New way
        names = namesList.toArray(String[]::new);
        System.out.println(names.length);
    }
}
