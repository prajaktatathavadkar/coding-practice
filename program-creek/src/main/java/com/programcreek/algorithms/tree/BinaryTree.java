package com.programcreek.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ptathavadkar
 */
public class BinaryTree {

    TreeNode root;

    public BinaryTree(int val) {

        root = new TreeNode(val);
    }

    public TreeNode add(int val) {

        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        return add(root, new TreeNode(val));
    }

    public TreeNode add(TreeNode current, TreeNode node) {

        if(node.val > current.val) {
            if(current.right == null) {
                current.right = node;
            } else {
                add(current.right, node);
            }
        } else {
            if(current.left == null) {
                current.left = node;
            } else {
                add(current.left, node);
            }
        }

        return root;
    }

    public void printPreOrder() {

        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(TreeNode node) {

        if(node != null) {
            System.out.print(node.val + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printInOrder() {

        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(TreeNode node) {

        if(node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }

    public void printPostOrder() {

        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(TreeNode node) {

        if(node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.val + " ");
        }
    }

    public void printBFS() {

        if(root  == null) {
            return;
        }
        printBFS(root);
        System.out.println();
    }

    private void printBFS(TreeNode root) {

        Queue<TreeNode> nodes = new LinkedList();
        nodes.add(root);
        while (nodes.size() > 0) {
            TreeNode node = nodes.poll();
            System.out.print(node.val + " ");
            if(node.left != null) {
                nodes.add(node.left);
            }
            if(node.right != null) {
                nodes.add(node.right);
            }
        }

    }

    public void printLevelOrder() {

        if(root  == null) {
            return;
        }
        printLevelOrder(root);
        System.out.println();

    }

    public void printLevelOrderReverse() {

        if(root  == null) {
            return;
        }
        printLevelOrderReverse(root);
        System.out.println();
    }

    private void printLevelOrder(TreeNode root) {

        printLevelOrder(root, false);
    }

    private void printLevelOrderReverse(TreeNode root) {

        printLevelOrder(root, true);
    }

    private void printLevelOrder(TreeNode root, boolean reverse) {

        Queue<TreeNode> currentLevel = new LinkedList();
        Queue<TreeNode> nextLevel = new LinkedList();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        currentLevel.add(root);

        while (currentLevel.size() > 0) {
            ArrayList<Integer> levelResult = new ArrayList<Integer>();
            while (currentLevel.size() > 0) {
                TreeNode node = currentLevel.poll();
                levelResult.add(node.val);
                if(node.left != null) {
                    nextLevel.add(node.left);
                }
                if(node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(levelResult);
            currentLevel.addAll(nextLevel);
            nextLevel.clear();
        }

        if(reverse) {
            Collections.reverse(result);
        }

        print(result);
    }

    private void print(ArrayList<ArrayList<Integer>> result) {

        for(ArrayList<Integer> levelResult : result) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(Integer val : levelResult) {
                sb.append(val);
                sb.append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1) + "]");
        }
    }
}
