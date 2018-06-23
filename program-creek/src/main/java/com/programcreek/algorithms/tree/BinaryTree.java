package com.programcreek.algorithms.tree;

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
}
