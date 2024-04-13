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
        // TODO: store events in log/DB
        events.add(event);
        // TODO: notify subscribed read repositories
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

    public void restoreEvents() {
        for (RoomBookedEvent event : roomBookedEvents) {
            processEvent(event);
        }
        for (BookingCancelledEvent event : bookingCancelledEvents) {
            processEvent(event);
        }
        for (CustomerCreatedEvent event : customerCreatedEvents) {
            processEvent(event);
        }
        for (RoomCreatedEvent event : roomCreatedEvents) {
            processEvent(event);
        }

        System.out.println("Events restored.");
    }

    public void getAllEvents() {

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



}
