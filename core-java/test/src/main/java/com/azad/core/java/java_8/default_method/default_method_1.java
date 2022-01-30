package com.azad.core.java.java_8.default_method;

/**
 * method that exist in interface by default without needing implementation, 
 * available to class that implement that interface, can be overriden (can also be static)
 */
public class default_method_1 {
    public static void main(String[] args){
        // normal use of default method in interface
        Vehicle vec = new Vehicle(){
            @Override
            public void printBike(){
                System.out.println("I'm a bike overrided");
            }
        };
        vec.print();
        vec.printBike();
        Vehicle.printLol();
    }
}

interface Vehicle{
    default void print(){
        System.out.println("I'm a vehicle");
    }
    default void printBike(){
        System.out.println("I'm a bike");
    }

    static void printLol() {
        System.out.println("lol!!!");
     }
}

interface Vehicle2{
    default void print(){
        System.out.println("I'm a vehicle 2");
    }
}

// case when two interface have same default method name
class Car implements Vehicle, Vehicle2{
    // to solve duplicate name define method with same name and use <interfacename>.super.<methodname>
    public void print(){
        Vehicle.super.print();
    }
}   