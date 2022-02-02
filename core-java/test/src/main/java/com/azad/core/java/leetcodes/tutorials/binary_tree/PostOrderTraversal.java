package com.azad.core.java.leetcodes.tutorials.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// postorder with stack 
public class PostOrderTraversal {

    public static void main(String[] args) {
        PostOrderTraversal sol = new PostOrderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode right5 = new TreeNode(5);
        TreeNode right6 = new TreeNode(6);
        TreeNode right7 = new TreeNode(7);
        TreeNode left2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);
        root.left = left2;
        left2.left = left3;
        left2.right = left4;

        root.right = right5;
        right5.left = right6;
        right5.right = right7;

        List<Integer> res = sol.postOrderTraversal(root);
        System.out.println(res);

    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            } 
        }
        return ans;
    }
}


