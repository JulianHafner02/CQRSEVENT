package at.fhv.lab1.commandclient.repositories;

import at.fhv.lab1.commandclient.domainmodel.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository
public class BookingRepository {

    private Set<Booking> bookings = new HashSet<>();

    public void save(Booking booking) {
        bookings.add(booking);
    }

    public boolean contains(Booking booking) {
        return bookings.contains(booking);
    }

    public void delete(Booking booking) {
        bookings.remove(booking);
    }

    public void deleteAll() {
        bookings.clear();
    }

    public Set<Booking> findAll() {
        return new HashSet<>(bookings);
    }

    public Booking findById(String id) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return bookings.isEmpty();
    }

    public int count() {
        return bookings.size();
    }
}
