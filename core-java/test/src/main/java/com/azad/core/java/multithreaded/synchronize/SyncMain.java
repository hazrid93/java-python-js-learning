package com.azad.core.java.multithreaded.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

interface GeneralCounter {
    void increment();
}

// trylock version for shared object
class CounterLock implements GeneralCounter{
    private volatile int c = 0;
    ReentrantLock lock = new ReentrantLock();

    public void increment() {
       // lock.lock();
        try {
            boolean isLockAcq = lock.tryLock(1, TimeUnit.SECONDS);
            if(isLockAcq) {
                try {
                    int sleepTimer = (int) (Math.random() * 100);
                    System.out.println("sleep timer: " + sleepTimer);
                    Thread.sleep(sleepTimer);
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
                c++;
            }
        }catch(Exception e){
            System.out.println("Lock issue");
        }
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}

// synchronized version for shared object
class Counter implements GeneralCounter{
    private volatile int c = 0;

    public synchronized void increment() {
        try {
            int sleepTimer = (int)(Math.random()*100);
            System.out.println("sleep timer: " + sleepTimer);
            Thread.sleep(sleepTimer);
        }catch (Exception  e) {

        }
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}

class DoCounter implements Runnable {
    private GeneralCounter counter;

    public DoCounter(GeneralCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            System.out.println("starting thread: " + Thread.currentThread().getName());
            // actual executed method
            this.caseIncrementTryLock();
        } catch (Exception e){
            System.out.println("from run: " + e.getMessage());
        }
    }

    public void caseIncrementSync() throws InterruptedException{
        this.counter.increment();
    }

    public void caseIncrementTryLock() throws InterruptedException{
        this.counter.increment();
    }
}

class DoSomething implements Runnable{

    @Override
    public void run()  {
        try {
            System.out.println("starting thread: " + Thread.currentThread().getName());
            // actual executed method
            this.case1Method();
        } catch (Exception e){
            System.out.println("from run: " + e.getMessage());
        }
    }

    private void printHello(){
        System.out.println("Hello from a thread!: " + Thread.currentThread().getName());
    }

    private void case1Method() throws InterruptedException{
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length;i++) {
            //Pause for 4 seconds
            try {
                Thread.sleep(800);
            }catch (InterruptedException e){
                //Thread.currentThread().interrupt();
                throw new InterruptedException(e.getMessage());
            }
            //Print a message
            System.out.println(importantInfo[i]);
        }
       this.case1Method();
    }

    private void case2Method() throws InterruptedException{
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length;i++) {
            //Pause for 4 seconds
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                //Thread.currentThread().interrupt();
                throw new InterruptedException(e.getMessage());
            }
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}

public class SyncMain {

    public static void main(String args[]) {
        // actual executed case
        // SyncMain.case1();
        // SyncMain.case2();
        SyncMain.case3();

    }

    //test thread join
    public static void case1(){

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        long patience = 1000 * 5 * 1;

        DoSomething something = new DoSomething();
        Thread threads1 = new Thread(something);
        long startTime = System.currentTimeMillis();
        threads1.start();
        System.out.println("Start execution");

        while(threads1.isAlive()){
            System.out.println("Thread waiting...");
            try {
                // join is to tell the program to wait for the thread to complete, without argument
                // it will wait indefinitely before next line of code
                threads1.join(1000);
                if (((System.currentTimeMillis() - startTime) > patience)
                        && threads1.isAlive()) {
                    System.out.println("Tired of waiting!");
                    threads1.interrupt();
                    // Shouldn't be long now
                    // -- wait indefinitely
                    threads1.join();
                }
            } catch (Exception e){
                System.out.println("from main, case1: " + e.getMessage());
            }
        }

        System.out.println("End execution");
    }

    // test interrupt
    public static void case2(){
        DoSomething something = new DoSomething();
        System.out.println("Start execution");
        // run multiple threads
        Thread threads[] = new Thread[5];
        for(int i=0;i<5;i++){
            threads[i] = new Thread(something);
            threads[i].start();
        }

        //interrupt a thread
        try {
            Thread.sleep(1500);
            threads[2].interrupt();
        } catch (Exception e){
            System.out.println("from main: " + e.getMessage());
        }
    }

    // test sync counter
    public static void case3() {
      //  Counter counter = new Counter();
        CounterLock counter = new CounterLock();
        DoCounter doCounter = new DoCounter(counter);
        System.out.println("Start execution");
        // run multiple threads
        int size = 250;
        Thread threads[] = new Thread[size];
        for(int i=0;i<size;i++){
            threads[i] = new Thread(doCounter);
            threads[i].start();
        }

        for(Thread thread: threads){
            try {
                thread.join();
            } catch (Exception e){
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
        System.out.println("End Execution, counter: " + counter.value());
    }
}
