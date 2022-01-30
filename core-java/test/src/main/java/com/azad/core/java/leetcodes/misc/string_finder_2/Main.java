package com.azad.core.java.leetcodes.misc.string_finder_2;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.azad.core.java.leetcodes.misc.string_finder_2.utils.TextGenerator;

public class Main {
    public static void main(String args[]){
        // generate random words
        Map<String, Boolean> wordData = TextGenerator.returnText();

        // clone stack and print original

        Map<String, Boolean> copiedWordData = wordData.entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("/// original map ///");
       // copiedWordData.entrySet().stream().forEach(data -> System.out.println(data.getKey() + ", " + data.getValue()));
       copiedWordData.forEach((k,v) -> System.out.println(k + ", " + v));

        System.out.println("/// original map ///");
        // prepare task executor
        TextTaskExecutor executor = new TextTaskExecutor(wordData);

        // prepare runnable class
        Runnable runner_1 = new Runnable(){

            int x = 0;
            @Override
            public void run() {
                    try {
                        // Proper way to handle interrupt and exception
                        // interrupt flag will stop the execution of while loop while still maintaining the exception
                        // thrown from execute().
                        // 1. if the interrupt flag is true, the thread is terminated
                        while(!Thread.interrupted()) {
                            // execute tasks...
                            System.out.println(" x: " + x);
                            if(x == 300) {
                                Thread.currentThread().interrupt();
                                System.out.println("Thread 1 interrupted from running ");
                            }
                            executor.execute();
                            Thread.sleep(new Random().nextInt(10) * 200);
                            x++;
                            System.out.println("Is thread_1 interrupted? : " + Thread.currentThread().isInterrupted());
                        }
                    } catch (Exception ex) {
                        // 2. When catch InterruptedException, thread is terminated
                       System.out.println("Error running " + this.getClass().getName() + ". message: " + ex.getMessage());
                    }
            }
        };

        Runnable runner_2 = new Runnable(){
            @Override
            public void run() {
                int x = 0;
                while(!Thread.interrupted()) {
                    try {
                        executor.execute();
                        Thread.sleep(new Random().nextInt(10) * 50);
                    } catch (Exception ex) {
                        System.out.println("Error running " + this.getClass().getName() + ". message: " + ex.getMessage());
                        break;
                    }
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
