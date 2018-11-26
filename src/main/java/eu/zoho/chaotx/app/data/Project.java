package eu.zoho.chaotx.app.data;

import java.util.ArrayList;
import java.util.List;

/**
 * A project is basically a collection
 * of bookings assoiciated to customers
 */
public class Project {
    private List<Booking> bookings;

    /**
     * Creates a new project without any bookings
     */
    public Project() {
        bookings = new ArrayList();
    }
    
    /**
     * Returns all bookings in this project
     * 
     * @return the list of bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }
}