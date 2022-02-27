package com.azad.core.java.leetcodes.problems.q1971_graph_findpathexist;

import java.util.HashSet;

// using DFS recursion
public class Solution3 {
    private boolean seen;
    
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
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
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;
        
        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
		if(graph[source].contains(destination)){  // direct connection exists
             return true;
        }
		
        seen = false;
        dfs(graph, visited, source, destination);
        return seen;
    }

    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int source, int destination){
        if(!visited[source] && !seen){
            if(source == destination){
                seen = true;
                return;
            }
            
            visited[source] = true;
            for(Integer neighbor : graph[source]){
                dfs(graph, visited, neighbor, destination);
            }
        }
    }
}
