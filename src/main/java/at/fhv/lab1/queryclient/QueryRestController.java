package at.fhv.lab1.queryclient;


import at.fhv.lab1.eventbus.events.BookingCancelledEvent;
import at.fhv.lab1.eventbus.events.CustomerCreatedEvent;
import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.queryclient.queries.GetBookings;
import at.fhv.lab1.queryclient.queries.GetCustomers;
import at.fhv.lab1.queryclient.queries.GetFreeRooms;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryRestController {


    public QueryRestController() {

    }

    @PostMapping(value = "/event", consumes = "application/json")
    public boolean addEvent(@RequestBody Event event) {
        // TODO: process event through projection
        System.out.println("Event from EventBus received: " + event);
        return true;
    }

    @PostMapping(value = "/roombookedevent", consumes = "application/json")
    public boolean addEvent(@RequestBody RoomBookedEvent event) {
        // TODO: process event through projection
        System.out.println("Event from EventBus received: " + event);
        return true;
    }

    @PostMapping(value = "/customercreatedevent", consumes = "application/json")
    public boolean addEvent(@RequestBody CustomerCreatedEvent event) {
        // TODO: process event through projection
        System.out.println("Event from EventBus received: " + event);
        return true;
    }

    @PostMapping(value = "/bookingcancelledevent", consumes = "application/json")
    public boolean addEvent(@RequestBody BookingCancelledEvent event) {
        // TODO: process event through projection
        System.out.println("Event from EventBus received: " + event);
        return true;
    }

    @PostMapping(value = "/getbookings", consumes = "application/json")
    public boolean addEvent(@RequestBody GetBookings query) {
        // TODO: process event through projection
        System.out.println("Query received: " + query);
        return true;
    }
    @PostMapping(value = "/getcustomers", consumes = "application/json")
    public boolean addEvent(@RequestBody GetCustomers query) {
        // TODO: process event through projection
        System.out.println("Query received: " + query);
        return true;
    }
    @PostMapping(value = "/getfreerooms", consumes = "application/json")
    public boolean addEvent(@RequestBody GetFreeRooms query) {
        // TODO: process event through projection
        System.out.println("Query received: " + query);
        return true;
    }
}
