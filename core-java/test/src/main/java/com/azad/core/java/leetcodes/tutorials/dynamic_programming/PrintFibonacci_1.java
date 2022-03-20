package com.azad.core.java.leetcodes.tutorials.dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// visualization https://i.stack.imgur.com/IQQfm.gif
// finding fibonacci value at index
public class PrintFibonacci_1 {
    Map<Integer,Integer> fibMap;

    public PrintFibonacci_1(){
        
    }
    
    public static void main(String[] args){
        PrintFibonacci_1 printFib = new PrintFibonacci_1();
        printFib.printFibonacci(40);// 40th fibonacci sequence value
    }

    public void printFibonacci(int end){
        if(end < 0){
            return;
        }
        long startTime = System.currentTimeMillis();
        // reset cache map
        fibMap = new HashMap<Integer,Integer>();
        int n = traverseFib(end);
        System.out.println(n);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("time taken (milli): " + TimeUnit.MILLISECONDS.toMillis(totalTime));

    }
    // 0,1,1,2,3,5 - fib series
    // if 5 then need fib(2) + fib(3)
    public int traverseFib(int val){
        if(fibMap.containsKey(val)){ // retrieve saved value in cache map
            return fibMap.get(val);
        }
        if(val == 0){
            return 0;
        }else if(val<=2 && val >=1){
            return 1;
        }

        // in multiple recursion statement  with a single line like this
        // the first function recursion will finish first before the second one
        // hence : traverseFib(val-1) complete first then traverseFib(val-2)
        int cur = traverseFib(val-1) + traverseFib(val-2);
        if(!fibMap.containsKey(val)){ //  saved execution value in cache map
            fibMap.put(val,cur);
        } 
        return cur;
    }
}
