package com.azad.core.java.leetcodes.tutorials.array;

//Find Numbers with Even Number of Digits
public class find_max_even {
    public static void main(String[] args){
       int[] nums = {12,345,2,6,7896};
       int res = findNumbers(nums);
       System.out.println("res: " + res);
    }

    public static int findNumbers(int[] nums) {
        int lengthCnt = 0;
        for(int i=0;i<nums.length;i++){
            // check if even
            String strNum = String.valueOf(nums[i]);
            if(strNum.length() %2  == 0){
                lengthCnt++;
                // find max length
                /*
                if(strNum.length() > lengthCnt){
                    lengthCnt = strNum.length();
                }
                */
            }
        }
        return lengthCnt;
    }
}
