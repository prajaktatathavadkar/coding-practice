package com.programcreek.algorithms.tree;

/**
 * @author ptathavadkar
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        // Depth First Search
        bt.printPreOrder();
        bt.printInOrder();
        bt.printPostOrder();

        // Breadth First Search
        bt.printBFS();

    }
}
