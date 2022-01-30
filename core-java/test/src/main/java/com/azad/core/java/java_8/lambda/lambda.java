package com.azad.core.java.java_8.lambda;

/**
 * 
 * Lambda expressions are used primarily to define inline implementation of a 
 * functional interface, i.e., an interface with a single method only. In the above example, we've used various types of lambda expressions to define the operation method of MathOperation interface. Then we have defined the implementation of sayMessage of GreetingService.
 * 
 * Lambda expression eliminates the need of anonymous class and gives a 
 * very simple yet powerful functional programming capability to Java.
 */
public class lambda {
    public static void main(String[] args) {
        // anonymous class way
        GreetingService gs1 = new GreetingService(){
            @Override
            public void say(String message) {
                System.out.println(message + " : from anon");
            }
        };
        gs1.say("hello world");

        // using lambda expression
        GreetingService gs2 = (String message) -> {
            System.out.println(message + " : from lambda");
        };
        gs2.say("hello world");
    }

    // functional interface (single method)
    // in interface variable are: public static final String
    // in interface method are : public abstract
    // interface can only be public or package access
    interface GreetingService {
        void say(String message);
    }
}
