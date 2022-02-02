package com.azad.core.java.leetcodes.tutorials.binary_tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// preorder with stack
public class preorder_traversal {
    public static void main(String[] args) {
        preorder_traversal sol = new preorder_traversal();
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

        List<Integer> res = sol.preorderTraversal(root);
        System.out.println(res);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}

