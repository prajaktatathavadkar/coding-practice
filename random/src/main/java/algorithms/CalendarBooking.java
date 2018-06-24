package algorithms;

import java.util.Date;

/**
 * @author ptathavadkar
 */
public class CalendarBooking {

    public static void main(String[] args) {

        Calendar calendar = new Calendar();
        long currTime = System.currentTimeMillis();

        // test case 1
        calendar.book(new Date(currTime + 60000), new Date(currTime + 120000));
        // test case 2
        calendar.book(new Date(currTime + 50000), new Date(currTime + 260000));
        // test case 3
        calendar.book(new Date(currTime + 120000), new Date(currTime + 180000));
        // test case 4
        calendar.book(new Date(currTime + 60000), new Date(currTime + 120000));
        // test case 5
        calendar.book(new Date(currTime + 240000), new Date(currTime + 360000));
        // test case 6
        calendar.book(new Date(currTime + 180000), new Date(currTime + 240000));
        // test case 7
        calendar.book(new Date(currTime + 180000), new Date(currTime + 240000));
        // test case 8
        calendar.book(new Date(currTime + 70000), new Date(currTime + 110000));
        // test case 9
        calendar.book(null, null);
    }
}
