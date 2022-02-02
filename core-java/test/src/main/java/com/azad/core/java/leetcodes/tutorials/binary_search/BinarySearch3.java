package com.azad.core.java.leetcodes.tutorials.binary_search;

// Template #3
public class BinarySearch3{
    public static void main(String[] args){
        BinarySearch1 bin = new BinarySearch1();
        int[] question = {23,25,26,29,32,40,41,45,51};
        int sol = bin.binarySearch(question, 40);
        System.out.println(sol);
    }

    int binarySearch(int[] nums, int target){
      if (nums == null || nums.length == 0)
        return -1;

      int left = 0, right = nums.length - 1;
      while (left + 1 < right){
          // Prevent (left + right) overflow
          int mid = left + (right - left) / 2;
          if (nums[mid] == target) {
              return mid;
          } else if (nums[mid] < target) {
              left = mid;
          } else {
              right = mid;
          }
      }

      // Post-processing:
      // End Condition: left + 1 == right
      if(nums[left] == target) return left;
      if(nums[right] == target) return right;
      return -1;
    }
}
