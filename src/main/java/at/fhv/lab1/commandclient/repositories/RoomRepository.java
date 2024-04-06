package at.fhv.lab1.commandclient.repositories;

import at.fhv.lab1.commandclient.domainmodel.Room;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RoomRepository {

    private Set<Room> rooms = new HashSet<>();

    public void save(Room room) {
        rooms.add(room);
    }

    public boolean contains(Room room) {
        return rooms.contains(room);
    }

    public void delete(Room room) {
        rooms.remove(room);
    }

    public void deleteAll() {
        rooms.clear();
    }

    public Set<Room> findAll() {
        return new HashSet<>(rooms);
    }

    public boolean isEmpty() {
        return rooms.isEmpty();
    }

    public int count() {
        return rooms.size();
    }
}
