package com.programcreek.algorithms.array;

/**
 * @author ptathavadkar
 */
public class Interval {

    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[")
                .append(start)
                .append(", ")
                .append(end)
                .append("] ")
                .toString();
    }
}
