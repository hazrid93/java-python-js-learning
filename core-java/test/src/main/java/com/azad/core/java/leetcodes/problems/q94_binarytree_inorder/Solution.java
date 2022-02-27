package com.azad.core.java.leetcodes.problems.q94_binarytree_inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
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

        List<Integer> res = sol.inorderTraversal(root);
        System.out.println(res);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while(curr!=null){
                stack.add(curr);
                // populate stack to left-most
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
