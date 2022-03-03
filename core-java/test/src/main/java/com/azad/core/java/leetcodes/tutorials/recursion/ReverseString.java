package com.azad.core.java.leetcodes.tutorials.recursion;

public class ReverseString {
    public static void main(String[] args){
        String name = "hazrid";
        reverse(name.toCharArray());
    }
    
    public static void reverse(char[] str){
        helper(0,str);
    }

    public static void helper(int index, char[] str){
        if(index<0 || index>=str.length){
            return;
        }
        
        helper(index+1,str);
        System.out.println(str[index]);
    }
}
