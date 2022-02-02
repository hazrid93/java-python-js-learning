package com.azad.core.java.basic.inner_class;

/**
 *  class written within a class is called the nested class, and the class that holds the inner class is called the outer class
 * in this example OuterClass is the 'Outer class'
 */
public class OuterClass {
    int x = 0;
    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        
        // have same name as OuterClass x
        int x = 1;
        void accessMembers() {
            // inner class (non static) can access instance field directly like here
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
        void shadowExample(int x){
            // this will print method arg 'x' instead of InnerClass or OuterClass x.
            System.out.println(x);
            // 'this' will refer to variable inside InnerClass, which is 'x=1';
            System.out.println(this.x);
            // this will finally print OuterClass 'x=0'
            System.out.println(OuterClass.this.x);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            // since its inner static class of OuterClass we can refer 'staticOuterField' without 'OuterClass.staticOuterField'
            // but class other than here need to use 'OuterClass.staticOuterField'
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();
        innerObject.shadowExample(25);

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();        
        staticNestedObject.accessMembers(outerObject);
        
        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        TopLevelClass topLevelObject = new TopLevelClass();        
        topLevelObject.accessMembers(outerObject);                
    }
}
