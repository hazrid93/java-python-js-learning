package com.azad.core.java.leetcodes.tutorials.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/** tree node1 is:
 *       (1)-root
 *    (2)    (3)
 * (4)   (5)
 * 
* */
public class LevelOrderTraversal_1 {
    public static void main(String[] args){
        // set up tree
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1,node2,node3);
        levelOrderTraverse(node1);
    }
    // traverse iteratively
    public static void levelOrderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            if(node == null){
                break;
            }
            System.out.println(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return;
    }
}
