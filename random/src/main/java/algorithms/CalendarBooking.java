package algorithms;

import java.util.Date;

/**
 * @author ptathavadkar
 */
public class CalendarBooking {

    public static void main(String[] args) {

        // test case 0
        Calendar calendar = new Calendar();
        long currTime = System.currentTimeMillis();
        calendar.book(new Date(currTime + 60000), new Date(currTime + 120000));
        calendar.book(new Date(currTime + 50000), new Date(currTime + 260000));
        calendar.book(new Date(currTime + 120000), new Date(currTime + 180000));
        calendar.book(new Date(currTime + 60000), new Date(currTime + 120000));
        calendar.book(new Date(currTime + 240000), new Date(currTime + 360000));
        calendar.book(new Date(currTime + 180000), new Date(currTime + 240000));
        calendar.book(new Date(currTime + 180000), new Date(currTime + 240000));
        calendar.book(new Date(currTime + 70000), new Date(currTime + 110000));
    }
}
