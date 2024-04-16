package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private final List<Event> events = new ArrayList<>();
    private final List<RoomBookedEvent> roomBookedEvents = new ArrayList<>();
    private final List<BookingCancelledEvent> bookingCancelledEvents = new ArrayList<>();
    private final List<CustomerCreatedEvent> customerCreatedEvents = new ArrayList<>();
    private final List<RoomCreatedEvent> roomCreatedEvents = new ArrayList<>();

    public void processEvent(Event event) {
        events.add(event);
        System.out.println("Processing Event");
    }

    public void processEvent(RoomBookedEvent event) {
        roomBookedEvents.add(event);
        System.out.println("Processing RoomBookedEvent: " + event);
    }

    public void processEvent(BookingCancelledEvent event) {
        bookingCancelledEvents.add(event);
        System.out.println("Processing BookingCancelledEvent: " + event);
    }

    public void processEvent(CustomerCreatedEvent event) {
        customerCreatedEvents.add(event);
        System.out.println("Processing CustomerCreatedEvent: " + event);
    }

    public void processEvent(RoomCreatedEvent event) {
        roomCreatedEvents.add(event);
        System.out.println("Processing RoomCreatedEvent: " + event);
    }

    public void printAllEvents() {

        for (RoomBookedEvent event : roomBookedEvents) {
            System.out.println(event);
        }
        for (BookingCancelledEvent event : bookingCancelledEvents) {
            System.out.println(event);
        }
        for (CustomerCreatedEvent event : customerCreatedEvents) {
            System.out.println(event);
        }
        for (RoomCreatedEvent event : roomCreatedEvents) {
            System.out.println(event);
        }
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public List<RoomBookedEvent> getAllRoomBookedEvents() {
        return new ArrayList<>(roomBookedEvents);
    }

    public List<BookingCancelledEvent> getAllBookingCancelledEvents() {
        return new ArrayList<>(bookingCancelledEvents);

    }

    public List<CustomerCreatedEvent> getAllCustomerCreatedEvents() {
        return new ArrayList<>(customerCreatedEvents);
    }

    public List<RoomCreatedEvent> getAllRoomCreatedEvents() {
        return new ArrayList<>(roomCreatedEvents);
    }
}
