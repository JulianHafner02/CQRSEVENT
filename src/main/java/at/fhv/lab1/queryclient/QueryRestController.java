package at.fhv.lab1.queryclient;


import at.fhv.lab1.eventbus.events.*;
import at.fhv.lab1.queryclient.handler.QueryHandler;
import at.fhv.lab1.queryclient.queries.GetBookings;
import at.fhv.lab1.queryclient.queries.GetCustomers;
import at.fhv.lab1.queryclient.queries.GetFreeRooms;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueryRestController {


    private final QueryHandler queryHandler;

    public QueryRestController(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }


    @PostMapping(value = "/event", consumes = "application/json")
    public boolean addEvent(@RequestBody Event event) {

        System.out.println("Event from EventBus received: " + event);


        return true;
    }

    @PostMapping(value = "/roombookedevent", consumes = "application/json")
    public boolean addEvent(@RequestBody RoomBookedEvent event) {

        System.out.println("Event from EventBus received: " + event);

        queryHandler.processEvent(event);

        return true;
    }

    @PostMapping(value = "/customercreatedevent", consumes = "application/json")
    public boolean addEvent(@RequestBody CustomerCreatedEvent event) {

        System.out.println("Event from EventBus received: " + event);

        queryHandler.processEvent(event);

        return true;
    }

    @PostMapping(value = "/bookingcancelledevent", consumes = "application/json")
    public boolean addEvent(@RequestBody BookingCancelledEvent event) {

        System.out.println("Event from EventBus received: " + event);

        queryHandler.processEvent(event);

        return true;
    }

    @PostMapping(value = "/roomcreatedevent", consumes = "application/json")
    public boolean addEvent(@RequestBody RoomCreatedEvent event) {

        System.out.println("Event from EventBus received: " + event);

        queryHandler.processEvent(event);

        return true;
    }
    @PostMapping(value = "/getbookings", consumes = "application/json")
    public boolean addEvent(@RequestBody GetBookings query) {

        System.out.println("Query received: " + query);
        return true;
    }
    @PostMapping(value = "/getcustomers", consumes = "application/json")
    public boolean addEvent(@RequestBody GetCustomers query) {

        System.out.println("Query received: " + query);
        return true;
    }
    @PostMapping(value = "/getfreerooms", consumes = "application/json")
    public boolean addEvent(@RequestBody GetFreeRooms query) {

        System.out.println("Query received: " + query);
        return true;
    }
}
