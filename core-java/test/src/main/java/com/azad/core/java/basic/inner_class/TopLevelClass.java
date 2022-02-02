package com.azad.core.java.basic.inner_class;

// basically a different class
public class TopLevelClass {
    public static void main(String[] args) {

    }

    public void accessMembers(OuterClass outer) {     
        // Compiler error: Cannot make a static reference to the non-static
        //     field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        // need to use 'OuterClass.staticOuterField' and not just staticOuterField, since  TopLevelClass  is different class 
        System.out.println(OuterClass.staticOuterField);
    }  
}
