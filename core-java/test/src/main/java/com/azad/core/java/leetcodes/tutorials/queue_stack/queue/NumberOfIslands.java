package com.azad.core.java.leetcodes.tutorials.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

// QUEUE implementation
/** 
 * 
 * [PROBLEM STATEMENT]
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) 
 * and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting 
 * adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 */ 

 // <TODO> this mostly work well but there are fail test case on leetcode, revisit later
public class NumberOfIslands {
    public static void main(String[] args){
        NumberOfIslands sol = new NumberOfIslands();
        // 1. start from [0][0]
        // 2. BFS nearest neighbour, before adding neighbor change current one to 'x' to mark as visited, then remove current one from queue
        // 3. keep adding to queue, also change
        // 4. if its 0 dont add to queue
        // 5. when queue is empty consider complete , number of island ++.
        char[][] question = { 
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','1','1'}
        };
        int result = sol.numIslands(question);
        System.out.println("result: " + result);
    }

    public int numIslands(char[][] grid) {
        Deque<String> data = new ArrayDeque<>();
        int count = 0;
        char row = '0';
        char col = '0';
        boolean goAgain = true;

        data.add("" + row + col);
        while(goAgain && !data.isEmpty()){
            // index 0 = i, index 1 = j
            Integer[] currItem = new Integer[2];
            char[] charArray = data.remove().toCharArray();
            for(int i=0;i<charArray.length;i++){
                // need to use getNumericValue(), if not any conversion from char
                // to integer in java will give ascii result and vice versa
                currItem[i] = Character.getNumericValue(charArray[i]);
            }

            // add neighbouring
            // grid[i,j+1]
            // grid[i+1,j+1]
            // grid[i+1,j]
            if((currItem[1]) < grid[0].length
                    && (currItem[0]) < grid.length){
                if(grid[currItem[0]][currItem[1]] == '1'){
                    grid[currItem[0]][currItem[1]] = 'X'; // mark this as visited
                        data.add("" + currItem[0] +  (currItem[1]+1));
                        data.add("" + (currItem[0]+1) +  (currItem[1]+1));
                        data.add("" + (currItem[0]+1) +  currItem[1]);
                } 
            }
            
            // visualize out the current island state and find next island
            if(data.isEmpty()){
                // print section
                for(int i=0; i<grid.length; i++){
                    StringBuffer log = new StringBuffer();
                    for(int j=0;j<grid[0].length;j++){
                        log.append(" " + grid[i][j]);
                    }
                    System.out.println(log.toString());
                }
                count++;
                goAgain = false;
                // continue another island search
                checking:
                for(int i=0; i<grid.length; i++){
                    for(int j=0;j<grid[0].length;j++){
                        if(grid[i][j] == '1'){
                            // use forDigit to avoid conversion to ASCII, instead get literal conversion  e.x:'1' -> 1
                            row = Character.forDigit(i,10);
                            col = Character.forDigit(j,10);
                            goAgain = true;
                            data.add("" + row + col);
                            break checking;
                        }
                    }
                }
            }
        }
        return count;
    }
}
