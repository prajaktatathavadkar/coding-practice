package algorithms;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * @author ptathavadkar
 */
public class Calendar {

    PriorityQueue<Booking> bookings;

    public Calendar() {
        this.bookings = new PriorityQueue<Booking>(1, new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                return o1.start.compareTo(o2.start);
            }
        });
    }

    // O(log(n)) time O(n) space
    public boolean book(Date start, Date end) {

        if(start == null || end == null) {

            System.out.println("Start/End of meeting cannot be null");
            return false;
        }

        if(end.before(start) || end.equals(start)) {

            System.out.println("End of meeting should be after start");
            return false;
        }

        if(end.before(new Date(System.currentTimeMillis()))
                || start.before(new Date(System.currentTimeMillis()))) {

            System.out.println("Cannot book meeting in the past");
            return false;
        }

        if (canBook(start, end)) {
            System.out.println("Booked meeting from " + start + " to " + end);
            bookings.add(new Booking(start, end));
            return true;
        } else {
            System.out.println("Conflict found. Cannot book meeting from " + start + " to " + end);
            return false;
        }
    }

    private boolean canBook(Date start, Date end) {

        PriorityQueue<Booking> tempQueue = new PriorityQueue<Booking>(bookings);

        while (tempQueue.size() > 0) {
            Booking booking = tempQueue.poll();
            // before
            if (end.compareTo(booking.start) <= 0) {
                return true;
            }
            // overlap
            else if (end.compareTo(booking.end) <= 0 || start.compareTo(booking.end) < 0) {
                return false;
            }
        }
        return true;
    }

}
