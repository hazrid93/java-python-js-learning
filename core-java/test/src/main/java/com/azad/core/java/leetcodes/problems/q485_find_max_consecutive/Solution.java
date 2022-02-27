package com.azad.core.java.leetcodes.problems.q485_find_max_consecutive;

public class Solution {
    public static void main(String[] args){
        int[] nums = {1,1,0,1,1,1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println("res: " + res);
     }
 
     //finding longest consecutive 1
     public static int findMaxConsecutiveOnes(int[] nums) {
         int c1 = 0;
         int maxc1 = 0;
         for(int i=0;i<nums.length;i++){
             if(nums[i] == 1){
                 c1++;
             } else {
                 if(c1 > maxc1) {
                     maxc1 = c1;
                 }
                 // reset back to zero if not one
                 c1 = 0;
             }
         }
 
         return (maxc1 == 0 ) ? c1 : (maxc1 > c1) ? maxc1 : c1;
     }
}
