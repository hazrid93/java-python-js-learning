package com.azad.core.java.leetcodes.problems.q278_first_bad_version;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Solution2 {
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
    /** 
     * It is obvious that the version would looks like the following:
     * FFTTTT (The first two are correct version, the rest are bad ones)
     * So we can use binary search to find the rightmost F or the leftmost T
    */
    public int firstBadVersion(int n) {
        if(n<1){
            return -1;
        }
        int i = 1;
        int j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        return i;
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
