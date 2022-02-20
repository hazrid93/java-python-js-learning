package com.azad.core.java.leetcodes.problems.q704_binary_search;

public class Solution {
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] question = {-1,0,3,5,9,12};
       // int[] question = {-1,0};
        int solution = sol.search(question, 9);

        System.out.println(solution);
    }

    public int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        // intialize index
        int left = 0;
        int right = nums.length - 1;
        // note java int division are always like math.floor()
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){ 
                // return index when reached target
                return mid;
            } else if(target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1 ;
            }
        }

        // no result
        return -1;

    }
}
