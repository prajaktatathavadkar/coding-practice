package com.programcreek.algorithms.array;

import java.util.PriorityQueue;

/**
 * @author ptathavadkar
 */
public class KthLargestElement {

    private static MaximumIntComparator maximumIntComparator = new MaximumIntComparator();

    public static void main(String[] args) {

        // test case 1
        int[] inputArr1 = {3,2,1,5,6,4};
        int k = 2;
        process(inputArr1, k);

        // test case 2
        int[] inputArr2 = {3,2,1,5,6,4};
        k = 0;
        process(inputArr2, k);

        // test case 3
        int[] inputArr3 = {3,2,1,5,6,4};
        k = 10;
        process(inputArr3, k);

        // test case 4
        int[] inputArr4 = {-1,1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        k = 10;
        process(inputArr4, k);

        // test case 5
        int[] inputArr5 = null;
        k = 2;
        process(inputArr5, k);
    }

    // O(nlog(k)) time O(k) space
    private static void process(int[] inputArr, int k) {

        if (inputArr == null || k <= 0 || k > inputArr.length) {
            System.out.println("Invalid input");
            return;
        }

        int maxK = getKthLargestElement(inputArr, k);

        System.out.println(maxK);
    }

    private static int getKthLargestElement(int[] inputArr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(inputArr.length, maximumIntComparator);

        for(int i : inputArr) {
            maxHeap.add(i);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
