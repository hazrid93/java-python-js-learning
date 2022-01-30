package com.azad.core.java.leetcodes.misc.string_finder_1;

import java.util.Stack;

import com.azad.core.java.leetcodes.misc.string_finder_1.utils.TextGenerator;

public class Main {
    public static void main(String args[]){
        // generate random words
        Stack<String> wordData = TextGenerator.returnText();

        // clone stack and print original
        Stack<String> copiedWordData = (Stack) wordData.clone();
        System.out.println("/// original stack ///");
        while(!copiedWordData.isEmpty()){
            System.out.println(copiedWordData.pop());
        }
        System.out.println("/// original stack ///");

        // prepare task executor
        TextTaskExecutor executor_1 = new TextTaskExecutor(wordData);
        TextTaskExecutor executor_2 = new TextTaskExecutor(wordData);

        // prepare runnable class
        Runnable runner_1 = new Runnable(){
            @Override
            public void run() {
                try{
                    executor_1.execute();
                } catch(Exception ex){
                    System.out.println("Error running " + this.getClass().getName() + ". message: " + ex.getMessage());
                }
            }
        };

        Runnable runner_2 = new Runnable(){
            @Override
            public void run() {
                try{
                    executor_2.execute();
                } catch(Exception ex){
                    System.out.println("Error running " + this.getClass().getName() + ". message: " + ex.getMessage());
                }
            }
        };

        // create thread and run
        System.out.println("/// modified stack ///");

        Thread thread_1 = new Thread(runner_1);
        Thread thread_2 = new Thread(runner_2);
        thread_1.start();
        thread_2.start();

        try {
            // wait thread to complete
            thread_1.join();
            thread_2.join();
        } catch (Exception ex){
            System.out.println("Exception caught: " + ex.getMessage());
        }

        System.out.println("/// modified stack ///");
        System.out.println("End of execution");
    }
}
