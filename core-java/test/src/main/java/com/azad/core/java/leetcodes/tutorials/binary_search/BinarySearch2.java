package com.azad.core.java.leetcodes.tutorials.binary_search;

// Template #2 is an advanced form of Binary Search. 
// It is used to search for an element or condition which requires 
// accessing the current index and its immediate right neighbor's index in the array.
public class BinarySearch2{
    public static void main(String[] args){
        BinarySearch1 bin = new BinarySearch1();
        int[] question = {23,25,26,29,32,40,41,45,51};
        int sol = bin.binarySearch(question, 40);
        System.out.println(sol);
    }

    int binarySearch(int[] nums, int target){
      if(nums == null || nums.length == 0)
      return -1;
  
      int left = 0, right = nums.length;
      while(left < right){
        // Prevent (left + right) overflow
        // in java dividing two integer result is always floored (math.floor())
        int mid = left + (right - left) / 2;
        if(nums[mid] == target){ return mid; }
        else if(nums[mid] < target) { left = mid + 1; }
        else { right = mid; }
      }
    
      // Post-processing:
      // End Condition: left == right
      if(left != nums.length && nums[left] == target) return left;
      return -1;
    }
}
