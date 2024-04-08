package at.fhv.lab1.queryclient.repositories;

import at.fhv.lab1.queryclient.projectedmodel.ProjectedBooking;

import java.util.HashSet;
import java.util.Set;

public class ProjectedBookingRepository {

    private final Set<ProjectedBooking> projectedBookings = new HashSet<>();

    // Save method
    public void save(ProjectedBooking booking) {
        projectedBookings.add(booking);
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
}