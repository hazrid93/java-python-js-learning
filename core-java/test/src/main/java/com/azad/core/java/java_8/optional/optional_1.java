package com.azad.core.java.java_8.optional;

import java.util.Optional;

import javax.sound.midi.SysexMessage;

/**
 * Optional is a container object used to contain not-null objects. 
 * Optional object is used to represent null with absent value. 
 * This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values
 * @see <a href="https://www.baeldung.com/java-optional">more info here : Baeldung</a>
 */
public class optional_1 {

    public static void main(String[] args){
        Integer value1 = null;
        Integer value2 = 20;

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> optional1 = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> optional2 = Optional.of(value2);

        // isPresent() Returns true if there is a value present, otherwise false.
        // isEmpty() Returns true if there is not a value present, otherwise false.
        if(optional1.isPresent() && !optional1.isEmpty()){
            System.out.println("optional1 is here");
        } else {
            System.out.println("optional1 is not here");
        }

        // Optional.orElse - returns the value if present otherwise returns the default value passed. (wiill always call given function whether you want it or not, regardless of Optional.isPresent() value)
        // or Optional.orElseGet - difference with orElse is that if value exist orElseGet wont invoke, but orElse will. (only when Optional.isPresent() == false)
        optional1.orElse(12);


        /// get() return the value , can throw exception if doesnt exist
        System.out.println("get(): " + optional2.get());
        
    }
}
