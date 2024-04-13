package at.fhv.lab1.commandclient.handler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.BookRoomCommand;
import at.fhv.lab1.commandclient.commands.CancelBookingCommand;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.CreateRoomCommand;
import at.fhv.lab1.commandclient.domainmodel.Booking;
import at.fhv.lab1.commandclient.domainmodel.Customer;
import at.fhv.lab1.commandclient.domainmodel.Room;
import at.fhv.lab1.commandclient.repositories.BookingRepository;
import at.fhv.lab1.commandclient.repositories.CustomerRepository;
import at.fhv.lab1.commandclient.repositories.RoomRepository;
import at.fhv.lab1.eventbus.events.BookingCancelledEvent;
import at.fhv.lab1.eventbus.events.CustomerCreatedEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.eventbus.events.RoomCreatedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class CommandHandler {

    private final EventPublisher eventPublisher;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;


    public CommandHandler(EventPublisher eventPublisher, BookingRepository bookingRepository, CustomerRepository customerRepository, RoomRepository roomRepository) {
        this.eventPublisher = eventPublisher;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }


    public void handleCommand(BookRoomCommand command) {
        // Validieren Sie den Befehl

        if (command.getCustomer() == null || command.getRoom() == null || command.getStartTime() == null || command.getEndTime() == null) {
            // Handle null fields
            // You can throw an exception or return an error message
            System.out.println("Null fields");
        } else if (command.getStartTime().isAfter(command.getEndTime())) {
            // Handle invalid start and end time
            // You can throw an exception or return an error message
            System.out.println("Invalid start and end time");
        } else if (!customerRepository.contains(command.getCustomer()) || !roomRepository.contains(command.getRoom())) {
            // Handle non-existing customer or room
            // You can throw an exception or return an error message
            System.out.println("Non-existing customer or room");
        } else {
            bookingRepository.save(new Booking(command.getBookingId(), command.getRoom(), command.getCustomer(), command.getStartTime(), command.getEndTime()));
            // Nach erfolgreicher Verarbeitung des Befehls, Ereignis erstellen und veröffentlichen
            RoomBookedEvent event = new RoomBookedEvent();
            event.setBookingId(command.getBookingId());
            event.setRoom(command.getRoom());
            event.setCustomer(command.getCustomer());
            event.setStartTime(command.getStartTime());
            event.setEndTime(command.getEndTime());
            System.out.println(event);
            eventPublisher.publishEvent(event);
        }


    }

    public void handleCommand(CancelBookingCommand command) {
        // Validieren Sie den Befehl

        if (!bookingRepository.contains(bookingRepository.findById(command.getBookingId()))) {
            // Handle non-existing reservation
            // You can throw an exception or return an error message
            System.out.println("Non-existing reservation");
        }
        else if (command.getBookingId() == null) {
            // Handle null reservation number
            // You can throw an exception or return an error message
            System.out.println("Null reservation number");
        }
        else {

            bookingRepository.delete(bookingRepository.findById(command.getBookingId()));
            // Nach erfolgreicher Stornierung, Ereignis erstellen und veröffentlichen
            BookingCancelledEvent event = new BookingCancelledEvent();
            event.setBookingId(command.getBookingId());
            System.out.println(event);
            eventPublisher.publishEvent(event);
        }
    }

    public void handleCommand(CreateCustomerCommand command) {
        // Validieren Sie den Befehl
        if (command.getName() == null || command.getAddress() == null || command.getDateOfBirth() == null) {
            // Handle null fields
            // You can throw an exception or return an error message
            System.out.println("Null fields");

        }
        else if (command.getDateOfBirth().isAfter(LocalDate.now())) {
            // Handle invalid date of birth
            // You can throw an exception or return an error message
            System.out.println("Invalid date of birth");
        }
        else {
            customerRepository.save(new Customer(command.getName(), command.getAddress(), command.getDateOfBirth()));

            //Nach erfolgreicher Erstellung, Ereignis erstellen und veröffentlichen
            CustomerCreatedEvent event = new CustomerCreatedEvent();
            event.setName(command.getName());
            event.setAddress(command.getAddress());
            event.setDateOfBirth(command.getDateOfBirth());
            System.out.println(event);
            eventPublisher.publishEvent(event);
        }

    }

    public void handleCommand(CreateRoomCommand command) {
        // Validieren Sie den Befehl
        if (command.getRoomNumber() == null) {
            // Handle null fields
            // You can throw an exception or return an error message
            System.out.println("Null fields");
        }
        else if (command.getCapacity() < 1) {
            // Handle invalid capacity
            // You can throw an exception or return an error message
            System.out.println("Invalid capacity");
        }
        else {
            roomRepository.save(new Room(command.getRoomNumber(), command.getCapacity()));
            //Nach erfolgreicher Erstellung, Ereignis erstellen und veröffentlichen
            RoomCreatedEvent event = new RoomCreatedEvent();
            event.setRoomNumber(command.getRoomNumber());
            event.setCapacity(command.getCapacity());
            System.out.println(event);
            eventPublisher.publishEvent(event);
        }

    }

}
