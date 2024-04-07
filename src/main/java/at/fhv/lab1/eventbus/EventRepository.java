package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.BookingCancelledEvent;
import at.fhv.lab1.eventbus.events.CustomerCreatedEvent;
import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {

    private final List<Event> events = new ArrayList<>();
    private final List<RoomBookedEvent> roomBookedEvents = new ArrayList<>();
    private final List<BookingCancelledEvent> bookingCancelledEvents = new ArrayList<>();
    private final List<CustomerCreatedEvent> customerCreatedEvents = new ArrayList<>();

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



}
