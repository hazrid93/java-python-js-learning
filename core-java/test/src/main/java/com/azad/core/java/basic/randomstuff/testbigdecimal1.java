package com.azad.core.java.basic.randomstuff;

import java.math.BigDecimal;

public class testbigdecimal1 {
    public static void main(String[] args) throws Exception {
        BigDecimal test = new BigDecimal("0.01");
        if(test.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("zero"+ " " + test);
        }
        System.out.println( test);
    }
}
