package at.fhv.lab1.queryclient.repositories;

import at.fhv.lab1.queryclient.projectedmodel.ProjectedRoom;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectedRoomRepository {

    private final Set<ProjectedRoom> projectedRooms = new HashSet<>();

    // Save method
    public void save(ProjectedRoom room) {
        projectedRooms.add(room);
    }

    // Contains method
    public boolean contains(ProjectedRoom room) {
        return projectedRooms.contains(room);
    }

    // Delete method
    public boolean delete(ProjectedRoom room) {
        return projectedRooms.remove(room);
    }

    // DeleteAll method
    public void deleteAll() {
        projectedRooms.clear();
    }

    // FindAll method
    public Set<ProjectedRoom> findAll() {
        return new HashSet<>(projectedRooms);
    }

    // IsEmpty method
    public boolean isEmpty() {
        return projectedRooms.isEmpty();
    }

    // Count method
    public int count() {
        return projectedRooms.size();
    }

    // Get all free rooms within a given date range and with specified capacity
    public Set<ProjectedRoom> getFreeRooms(LocalDate startDate, LocalDate endDate, int requiredCapacity) {
        return projectedRooms.stream()
                .filter(room -> room.getCapacity() >= requiredCapacity)
                .filter(room -> isRoomFree(room, startDate, endDate))
                .collect(Collectors.toSet());
    }

    // Check if a room is free within a given date range
    private boolean isRoomFree(ProjectedRoom room, LocalDate startDate, LocalDate endDate) {
        for (LocalDate bookedDate : room.getBookedFor()) {
            if (isDateOverlap(bookedDate, startDate, endDate)) {
                return false; // Room is booked for at least one day within the given range
            }
        }
        return true; // Room is free for all days within the given range
    }

    // Check if there is an overlap between two date ranges
    private boolean isDateOverlap(LocalDate bookedDate, LocalDate startDate, LocalDate endDate) {
        return !startDate.isAfter(bookedDate) && !endDate.isBefore(bookedDate);
    }
}
