package at.fhv.lab1.eventbus.rest;

import at.fhv.lab1.eventbus.EventPublisher;
import at.fhv.lab1.eventbus.EventRepository;
import at.fhv.lab1.eventbus.events.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController {

    private final EventRepository repository;

    private final EventPublisher publisher;

    public EventRestController(EventRepository repository, EventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @PostMapping(value = "/event", consumes = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event from CommandClient received: " + event);
        return true;
    }

    @PostMapping(value = "/roombookedevent", consumes = "application/json")
    public boolean addRoomBookedEvent(@RequestBody RoomBookedEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event from CommandClient received: " + event);
        publisher.publishEvent(event);
        return true;
    }

    @PostMapping(value = "/customercreatedevent", consumes = "application/json")
    public boolean addCustomerCreatedEvent(@RequestBody CustomerCreatedEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event from CommandClient received: " + event);
        publisher.publishEvent(event);
        return true;
    }

    @PostMapping(value = "/bookingcancelledevent", consumes = "application/json")
    public boolean addBookingCancelledEvent(@RequestBody BookingCancelledEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event from CommandClient received: " + event);
        publisher.publishEvent(event);
        return true;
    }

    @PostMapping(value = "/roomcreatedevent", consumes = "application/json")
    public boolean addBookingCancelledEvent(@RequestBody RoomCreatedEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event from CommandClient received: " + event);
        publisher.publishEvent(event);
        return true;
    }


}
