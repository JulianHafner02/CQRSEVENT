package at.fhv.lab1.queryclient.repositories;

import at.fhv.lab1.eventbus.events.BookingCancelledEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.queryclient.projectedmodel.ProjectedBooking;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Repository
public class ProjectedBookingRepository {

    private final Set<ProjectedBooking> projectedBookings = new HashSet<>();


    // Save method
    public void save(ProjectedBooking booking) {
        projectedBookings.add(booking);
    }

    public ProjectedBooking findByBookingId(String bookingId) {
        for (ProjectedBooking booking : projectedBookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    // Contains method
    public boolean contains(ProjectedBooking booking) {
        return projectedBookings.contains(booking);
    }

    // Delete method
    public boolean delete(ProjectedBooking booking) {
        return projectedBookings.remove(booking);
    }

    // DeleteAll method
    public void deleteAll() {
        projectedBookings.clear();
    }

    // FindAll method
    public Set<ProjectedBooking> findAll() {
        return new HashSet<>(projectedBookings);
    }

    // IsEmpty method
    public boolean isEmpty() {
        return projectedBookings.isEmpty();
    }

    // Count method
    public int count() {
        return projectedBookings.size();
    }

    public Set<ProjectedBooking> findBookingsByDates(LocalDate startDate, LocalDate endDate) {
        Set<ProjectedBooking> result = new HashSet<>();
        for (ProjectedBooking booking : projectedBookings) {
            if (booking.getStartDate().isAfter(startDate) && booking.getEndDate().isBefore(endDate)) {
                result.add(booking);
            }
        }
        return result;

    }


}