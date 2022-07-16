package com.azad.core.java.multithreaded.synchronize.producer_consumer_1;

import java.util.Random;

//this class will be passed to runnable implementing class
// will only allow one take and one put
class DataDrop {
    private String message;

    private boolean empty = true;

    public synchronized String take(){
        while(empty){
            try{
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = true;
        // notify other producer waiting thread status has changed
        notifyAll();
        return message;
    }

    public synchronized void put(String message){
        while(!empty){
            try{
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
        // notify other consumer status has changed
        notifyAll();
    }

}

// the class that will be passed to java Thread
// multiple producer will use same object reference to 'Drop' class
class Producer implements Runnable {
    private DataDrop drop;

    //make drop part of this instance
    public Producer(DataDrop drop) {
        this.drop = drop;
    }

    public void run() {
        /*
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        */
        Random random = new Random();

        while (true) {
            String putVal = String.valueOf(new Random().nextInt(20000));
            drop.put(putVal);
            System.out.format("MESSAGE PUT: %s%n", putVal);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
            }
        }
        //drop.put("DONE");
    }
}

class Consumer implements Runnable {
    private DataDrop drop;

    public Consumer(DataDrop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        /*
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        */
        while(true){
            String message = drop.take();
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumer {
    public static void main(String args[]){
        //case to call
        ProducerConsumer.normalProdConsume();
    }

    // normal prod-consumer with single message
    public static void normalProdConsume(){
        DataDrop drop = new DataDrop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
