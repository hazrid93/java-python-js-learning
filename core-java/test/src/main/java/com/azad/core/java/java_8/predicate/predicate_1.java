package com.azad.core.java.java_8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate <T> interface is a functional interface with a method test(Object) to return a Boolean value. This interface signifies that an object is tested to be true or false.
 * kinda similar to Comparable interface 
 * @see  <a href="https://www.tutorialspoint.com/java8/java8_functional_interfaces.htm">Tutorials Point</a>
 */
public class predicate_1 {
    public static void main(String[] args){
        /// - simple predicate usage
        List<Integer> list = Arrays.asList(0,1,2,3,4,5);
        evaluate(list, n -> n>3);

        // predicate.not() to negate existing predicate
        List<Integer> listPred = list.stream().filter(Predicate.not(n -> n>=3)).collect(Collectors.toList());
        System.out.println(listPred);
    
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate){
    for(Integer n: list) {
        // test() execute the function in predicate
         if(predicate.test(n)) {
            System.out.println(n + " ");
         }
      }
    }
}
