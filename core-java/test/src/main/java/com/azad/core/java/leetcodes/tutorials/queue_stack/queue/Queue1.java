package com.azad.core.java.leetcodes.tutorials.queue_stack;

import java.util.Arrays;

// design manual queue
public class Queue1 {

    private class MyQueue {
        int[] array;
        int head;

        MyQueue(int size) {
            this.array = new int[size];
            this.head = 0;

        }

        int[] copyArray(int[] arr){
            return Arrays.copyOfRange(arr, 0, arr.length);
        }

        boolean enqueue(int item){
            if(head+1 <= array.length){
                this.array[this.head] = item;
                this.head++;
                return true;
            } else {
                System.out.println("Fail to insert " + item + " array is full");
                return false;
            }
        }

        int size(){
            return this.array.length;
        }

        void print(){
            System.out.println("array content:");
            for(int i : this.array){
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args){
        Queue1 queue1 = new Queue1();
        MyQueue myQueue = queue1.new MyQueue(5);
        myQueue.enqueue(2);
        myQueue.enqueue(2);
        myQueue.enqueue(2);
        myQueue.enqueue(2);
        myQueue.enqueue(5);
        myQueue.enqueue(5);
        //System.out.println(myQueue.size());
        myQueue.print();

    }
}


