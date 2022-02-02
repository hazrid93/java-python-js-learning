package com.azad.core.java.leetcodes.tutorials.binary_search;

//Template #1 is the most basic and elementary form of Binary Search
public class BinarySearch1 {
    public static void main(String[] args){
        BinarySearch1 bin = new BinarySearch1();
        int[] question = {23,25,26,29,32,40,41,45,51};
        int sol = bin.binarySearch(question, 40);
        System.out.println(sol);
    }

    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
          return -1;
      
        int left = 0, right = nums.length - 1;
        while(left <= right){
          // Prevent (left + right) overflow
          int mid = left + (right - left) / 2;
          if(nums[mid] == target){ return mid; }
          else if(nums[mid] < target) { left = mid + 1; }
          else { right = mid - 1; }
        }
      
        // End Condition: left > right
        return -1;
      }
    
}
