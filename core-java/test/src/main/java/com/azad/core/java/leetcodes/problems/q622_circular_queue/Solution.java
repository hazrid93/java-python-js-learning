package com.azad.core.java.leetcodes.problems.q622_circular_queue;
// custom circular queue
// fail a testcase in leetcode check in future
public class Solution {
    private class MyCircularQueue {
        int[] arr;
        int head;
        int tail;
        int size;

        public MyCircularQueue(int size){
            this.head = -1;
            this.tail = -1;
            this.arr = new int[size];
            this.size = size;
        }

        boolean deQueue(){
            if(isEmpty()==true){
                head=0;
            }
            if(head==tail){
                head=-1;
                tail=-1;
                print();
                return true;
            }
            // alternative head = (head + 1) % size;
            // modulo work because when left side is smaller than right 
            // remainder is basically the left side 
            // e.x 2%5 = 2, because 5 cannot fit into 2 (zero times),
            // hence remainder is 2. But when 5%5 remainder will be zero (perfect for circular array)
            if(head+1==size){
                arr[head] = 0;
                head = 0;
            } else{
                arr[head] = 0;
                head++;
            }
            print();
            return true;
        }

        boolean enQueue(int item){
            if(isFull()==true){
                return false;
            }

            if(isEmpty()==true){
                head=0;
            }

            // alternative: tail = (tail + 1) % size;
            if(tail+1==size){
                tail = 0;
            }else{
                tail++;
            }
            arr[tail]=item;
            print();
            return true;
        }

        void print(){
            StringBuilder builder = new StringBuilder();
            for(int i : arr){
                builder.append("[" + i + "],");
            }
            builder.deleteCharAt(builder.length()-1);
            System.out.println(builder.toString());
        }

        int Front(){
            if(isEmpty()==true){
                return -1;
            }
            return arr[head];
        }

        int Rear(){
            if(isEmpty()==true){
                return -1;
            }
            return arr[tail];
        }
        
        boolean isFull(){
            if(tail+1 == head){
                System.out.println("is full");
                return true;
            } else if(head==0 && tail==this.size-1){
                System.out.println("is full");
                return true;
            } else{
                return false;
            }
        }

        boolean isEmpty(){
            return head == -1;
        }
    }
    public static void main(String[] args){
        Solution cir1 = new Solution();
        MyCircularQueue ans = cir1.new MyCircularQueue(5);
        ans.enQueue(1);
        ans.enQueue(2);
        ans.enQueue(3);
        ans.deQueue();
        ans.deQueue();
        ans.enQueue(5);
        ans.enQueue(6);
        ans.enQueue(7);
        ans.enQueue(8);
        ans.enQueue(9); // is full
        ans.deQueue(); 
        ans.deQueue(); 
        ans.deQueue(); 
        ans.deQueue(); // all empty
        ans.enQueue(10);
        ans.enQueue(11);
        ans.enQueue(12);
        ans.enQueue(13);
        ans.enQueue(14);
        ans.enQueue(15); // is full
    }
}
