package com.azad.core.java.basic.array;

import java.util.stream.IntStream;

public class PrimitiveArray_1 {
    public static void main(String[] args){
        int[] myIntArray = new int[3];
        int[] myIntArray2 = {1, 2, 3};
        int[] myIntArray3 = new int[]{1, 2, 3};
    
        // Since Java 8. Doc of IntStream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
    
        int [] myIntArray4 = IntStream.range(0, 100).toArray(); // From 0 to 99
        int [] myIntArray5 = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
        int [] myIntArray6 = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved.
        int [] myIntArray7 = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort
    }
     
}
