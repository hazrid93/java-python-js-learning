package com.azad.core.java.leetcodes.tutorials.recursion;
// print value from top to bottom using recursion
public class PrintValue {
    public static void main(String[] args){
        solve(8);
    }

    public static void solve(int n){
        // Base condition
        if(n == 0) return;
        System.out.println(n); // Induction
        solve(n - 1); // Hypothesis
      }
}
