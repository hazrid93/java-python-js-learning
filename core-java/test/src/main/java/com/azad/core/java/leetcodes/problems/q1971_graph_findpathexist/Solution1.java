package com.azad.core.java.leetcodes.problems.q1971_graph_findpathexist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// solve using queue BFS
public class Solution1 {
    private boolean seen;
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n = 5;
        int[][] edges = {
            {0,1},
            {1,2},
            {2,0},
            {2,3},
            {3,4}
        };
        int source = 0;
        int destination = 2;

        boolean result = solution.validPath(n, edges, source, destination);
        System.out.println(result);

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // default boolean false for node visited
        boolean[] visited = new boolean[n];
        // adjacency list e.x 
        // (0 -> 1),
        // (1 -> 2,3),
        // (2 -> 0)
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        // build graph with bidirectional edge
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int node = queue.poll();

            if (source == destination){
                return true;
            }

            // if already visited skip
            if(visited[node]){ 
                continue;
            }
            
            // since haven't visited, mark it visited
            visited[node] = true;

            for(int neighbour : graph.get(node)){
                queue.add(neighbour);
            }

        }

        return false;
    }
}
