package com.azad.core.java.leetcodes.tutorials.graph.disjoint_set;

public class Disjoint_1 {
    public static void main(String[] args){
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

// quick find :
// use index as vertice
// use array value as parent/root node
// set each index as its own parent node
// if index = parent then  its a root node (always have to travest the array to find root).
class QuickFind {
    private int[] root;

    public QuickFind(int size){
        root = new int[size];
        for(int i=0;i<size;i++){
            root[i] = i;
        }
    }

    public int find(int x){
        return root[x];
    }


    // merge vertice of y into x
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            //loop through whole array
            for(int i=0;i<root.length;i++){
                if(root[i] == rootY){
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}