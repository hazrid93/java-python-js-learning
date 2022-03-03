package com.azad.core.java.leetcodes.problems.q344_reversestring;

public class Solution {
    public static void main(String[] args){
        String name = "hazrid";
        char[] nameChar = name.toCharArray();
        reverse(nameChar);
        System.out.println(nameChar);
    }

    public static void reverse(char[] str){
        helper(0, str.length-1, str);
    }

    public static void helper(int start, int end , char[] str){
        if(start < 0 || end < 0 || start >=str.length){
            return;
        }

        helper(start+1,end-1,str);
        if(end>start){
            return;
        }
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
    }
}
