package com.careercup.algorithms.dropbox;

import java.util.ArrayList;

/**
 * @author ptathavadkar
 */
public class ByteArrayInByteFile {

    public static void main(String[] args) {

        byte[] byteArr = {3, 4, 5, 3};
        byte[] byteFile = {24, 3, 4, 5, 3, 4, 5, 3, 9, 25};

        process(byteArr, byteFile);
    }

    private static void process(byte[] byteArr, byte[] byteFile) {

        if(byteArr == null || byteFile == null || byteArr.length > byteFile.length) {
            System.out.println("Not found");
            return;
        }

        ArrayList<Integer> indices = find(byteArr, byteFile);
        for(int index: indices) {
            System.out.print(index + " ");
        }
    }

    private static ArrayList<Integer> find(byte[] byteArr, byte[] byteFile) {

        int expectedHash = calculateHash(byteArr);
        int currentHash = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < byteArr.length; ++i) {
            currentHash += Math.pow(7, i) * byteFile[i];
        }

        for(int i = byteArr.length; i < byteFile.length; ++i) {
            int startIndex = i - byteArr.length;
            if(currentHash == expectedHash) {
                result.add(startIndex);
            }
            currentHash -= Math.pow(7, 0) * byteFile[startIndex];
            currentHash += Math.pow(7, byteArr.length) * byteFile[i];
            currentHash /= 7;
        }

        return result;
    }

    private static int calculateHash(byte[] byteArr) {

        int result = 0;
        for(int i = 0; i < byteArr.length; ++i) {
            result += Math.pow(7, i) * byteArr[i];
        }
        return result;
    }
}
