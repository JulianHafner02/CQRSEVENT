package at.fhv.lab1.queryclient.handler;

import at.fhv.lab1.eventbus.events.BookingCancelledEvent;
import at.fhv.lab1.eventbus.events.CustomerCreatedEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.eventbus.events.RoomCreatedEvent;
import at.fhv.lab1.queryclient.projectedmodel.ProjectedBooking;
import at.fhv.lab1.queryclient.projectedmodel.ProjectedCustomer;
import at.fhv.lab1.queryclient.projectedmodel.ProjectedRoom;
import at.fhv.lab1.queryclient.queries.GetCustomers;
import at.fhv.lab1.queryclient.queries.GetFreeRooms;
import at.fhv.lab1.queryclient.queries.GetBookings;
import at.fhv.lab1.queryclient.repositories.ProjectedCustomerRepository;
import at.fhv.lab1.queryclient.repositories.ProjectedRoomRepository;
import at.fhv.lab1.queryclient.repositories.ProjectedBookingRepository;
import at.fhv.lab1.eventbus.EventRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class QueryHandler {

    private final EventRepository eventRepository;
    private final ProjectedCustomerRepository projectedCustomerRepository;
    private final ProjectedRoomRepository projectedRoomRepository;
    private final ProjectedBookingRepository projectedBookingRepository;

    public QueryHandler(EventRepository eventRepository, ProjectedCustomerRepository projectedCustomerRepository, ProjectedRoomRepository projectedRoomRepository, ProjectedBookingRepository projectedBookingRepository) {
        this.eventRepository = eventRepository;
        this.projectedCustomerRepository = projectedCustomerRepository;
        this.projectedRoomRepository = projectedRoomRepository;
        this.projectedBookingRepository = projectedBookingRepository;
    }

    public void processEvent(BookingCancelledEvent event) {
        if (projectedBookingRepository.contains(projectedBookingRepository.findByBookingId(event.getBookingId()))) {
            projectedBookingRepository.delete(projectedBookingRepository.findByBookingId(event.getBookingId()));

            projectedRoomRepository.deleteBookingsByDateRange((projectedBookingRepository.findByBookingId(event.getBookingId())).getRoom(), projectedBookingRepository.findByBookingId(event.getBookingId()).getStartDate(), projectedBookingRepository.findByBookingId(event.getBookingId()).getEndDate());

            System.out.println("Booking cancelled: " + event.getBookingId());
        }
        else {
            System.out.println("Booking not found");
        }
    }

    public void processEvent(RoomBookedEvent event) {
        if (!projectedBookingRepository.contains(projectedBookingRepository.findByBookingId(event.getBookingId()))) {
            projectedBookingRepository.save(new ProjectedBooking(event.getBookingId(), projectedRoomRepository.findByRoomNumber(event.getRoom().getRoomNumber()), projectedCustomerRepository.findByCustomerName(event.getCustomer().getName()), event.getStartTime(), event.getEndTime()));
        }

        System.out.println("Room booked: " + event.getBookingId());
    }

    public void processEvent(CustomerCreatedEvent event) {
        if (!projectedCustomerRepository.contains(projectedCustomerRepository.findByCustomerName(event.getName()))) {
            projectedCustomerRepository.save(new ProjectedCustomer(event.getName(), event.getAddress(), event.getDateOfBirth()));
        }

        System.out.println("Customer created: " + event.getName());
    }

    public void processEvent(RoomCreatedEvent event) {
        if (!projectedRoomRepository.contains(projectedRoomRepository.findByRoomNumber(event.getRoomNumber()))) {
            projectedRoomRepository.save(new ProjectedRoom(event.getRoomNumber(), event.getCapacity(), new ArrayList<>()));
        }

        System.out.println("Room created: " + event.getRoomNumber());
    }

    public void handleQuery(GetCustomers query) {

        if(query.getName().equals("all")) {
            System.out.println("All customers: ");
            projectedCustomerRepository.findAll().forEach(System.out::println);
        }
        else {
            if (projectedCustomerRepository.contains(projectedCustomerRepository.findByCustomerName(query.getName()))) {
                System.out.println(projectedCustomerRepository.findByCustomerName(query.getName()));
            }
            else {
                System.out.println("Customer not found");
            }
        }

    }

    public void handleQuery(GetBookings query) {

        System.out.println("Bookings: ");
        projectedBookingRepository.findBookingsByDates(query.getStartDate(), query.getEndDate()).forEach(System.out::println);

    }


    public void handleQuery(GetFreeRooms query) {
        System.out.println("Free rooms: ");
        projectedRoomRepository.getFreeRooms(query.getStartDate(), query.getEndDate(), query.getCapacity()).forEach(System.out::println);
    }

    public void deleteQueries() {
        projectedCustomerRepository.deleteAll();
        projectedRoomRepository.deleteAll();
        projectedBookingRepository.deleteAll();

        System.out.println("All query repositories deleted");
    }

    public void getAllEvents() {

        eventRepository.getAllEvents();
    }

    public void restoreEvents() {

        eventRepository.restoreEvents();
    }

}
