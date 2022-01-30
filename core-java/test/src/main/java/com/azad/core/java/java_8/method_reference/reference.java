package com.azad.core.java.java_8.method_reference;

import java.util.ArrayList;
import java.util.List;

/**
 * Method references help to point to methods by their names. A method reference is described using "::" symbol. A method reference can be used to point the following types of methods −
Static methods
Instance methods
Constructors using new operator (TreeSet::new)
 */
public class reference {

    public static void main(String[] args) {
        List<Integer> age1 = new ArrayList<>();
        age1.add(1);
        age1.add(2);
        age1.add(3);
        // without using reference
        age1.forEach(item -> {
            System.out.println("without reference: " + item);
        });

        // with using reference, equivalent to (x -> { System.out.println(x) })
        age1.forEach(System.out::println);
    }
    
}
