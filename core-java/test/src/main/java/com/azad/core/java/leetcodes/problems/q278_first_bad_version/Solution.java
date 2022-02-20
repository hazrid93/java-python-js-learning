package com.azad.core.java.leetcodes.problems.q278_first_bad_version;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// this solution somehow fail timelimit set by leetcode.
public class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Time start: " + start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        int res =  sol.firstBadVersion(2126753390);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Time end: " + end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println("Time taken: " +  ChronoUnit.MILLIS.between(start, end));
        System.out.println(res);
    }
    
    //You are given an API bool `isBadVersion(version)` which returns whether version is bad. 
    // theres no api that tell which particular version is bad so we need to optimized this.
    // version start from 1 as the lowest until 2^31
    // need binary search, if first bad version is version 2 but current version n is 1000 then is very un-optimal.
    public int firstBadVersion(int n) {
        // invalid version number
        if(n < 1){
            return -1 ;
        }
        // 1,2,[3],4,5,6,7,8,9,10*
        // solution
        int left = 1;
        int right = n;
        // left<=right to satisfy condition where the bad one is exactly the inputed version
        initialcheck: // labeled break
        while(left <= right){
            int mid = left + (right - left) / 2;
            boolean isBad = isBadVersion(mid);
            // always go left since right will always be bad, when we found midpoint that is not bad we set that as new left,
            // break from while loop and do another search from left to right. This way we limit the range of search.
            if(isBad){
                right = mid - 1;
            } else if(!isBad){
                left = mid;
                break initialcheck;
            }
        }
        if(left<right){
            for(int i=left;i<=right;i++){
                if(isBadVersion(i)){
                    return i;
                }
            }
        } else {
            if(isBadVersion(++right)){
                return right;
            }
        }

        // if cannot find answer
        return -1;
    }
    
    public boolean isBadVersion(int n){
        // first bad version is 4, all other version above 4 is also bad
        if(n>=1702766719){
            return true;
        } else {
            return false;
        }
    }
}
