package at.fhv.lab1;

import at.fhv.lab1.commandclient.commands.BookRoomCommand;
import at.fhv.lab1.commandclient.commands.CancelBookingCommand;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.commands.CreateRoomCommand;
import at.fhv.lab1.commandclient.domainmodel.Booking;
import at.fhv.lab1.commandclient.domainmodel.Customer;
import at.fhv.lab1.commandclient.domainmodel.Room;
import at.fhv.lab1.eventbus.events.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import at.fhv.lab1.eventbus.EventPublisher;
import at.fhv.lab1.commandclient.repositories.BookingRepository;
import at.fhv.lab1.commandclient.repositories.CustomerRepository;
import at.fhv.lab1.commandclient.repositories.RoomRepository;
import at.fhv.lab1.commandclient.handler.CommandHandler;


import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.commandclient")
public class CommandClientApplication implements CommandLineRunner{


    //private final EventPublisher publisher;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CommandHandler commandHandler;


    //TODO Ansteuern über CommandRunner (cmd/cli) ohne große validierung der ders verwendet woars au wies
    //TODO 2 clis (query and command)
    //TODO UI für dern Bumms macha optional
    //TODO Rollback der ganzen Events für die query sachen
    //TODO alle queries sachen löschen
    //TODO QueryHandler macha
    //TODO Events in Datei speichern (text oder json) optional
    //TODO Dokumentation macha (klassendiagramm und die ansteuerung der commands)
    //TODO beschreibung wie ma da cli verwendet
    //TODO create customer und create room wäre optional
    //TODO bei da process events sött ma die write db apassa und ned nur die read db (oder nur die write db apassa und denn wieda events macha???)






    public CommandClientApplication(RoomRepository roomRepository, BookingRepository bookingRepository, CustomerRepository customerRepository, CommandHandler commandHandler) {
        //this.publisher = publisher;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.commandHandler = commandHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandClientApplication.class, args);
    }

    public void run(String ... args) throws Exception {

        /*
        Event event = new Event();
        event.setContent("This is the content!");
        event.setCustomer("Customer1");
        event.setTimestamp(System.currentTimeMillis());
        System.out.println("Result: " + publisher.publishEvent(event));
        publisher.publishEvent(event);
         */

        System.out.println("Running");

        initialiseData();

        // Read input from the command line
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter a command:");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);
        } while (!input.equals("exit"));




        //TODO scan logic for commands and handle them accordingly

    }

    public void initialiseData() {

        // Create some sample data for rooms, bookings, and customers
        Room room1 = new Room("101", 2);
        Room room2 = new Room("102", 3);
        Room room3 = new Room("103", 1);
        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);

        Customer customer1 = new Customer( "John Doe", "123 Main St", LocalDate.of(1990, 5, 15));
        Customer customer2 = new Customer( "Jane Smith", "456 Elm St", LocalDate.of(1985, 8, 20));
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("1", room1, customer1, LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 18));
        Booking booking2 = new Booking("2", room2, customer2, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 12));
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);


        BookRoomCommand bookRoomCommand1 = new BookRoomCommand("3", room3, customer1, LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 18));
        BookRoomCommand bookRoomCommand2 = new BookRoomCommand("4", room2, customer2, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 12));
        commandHandler.handleCommand(bookRoomCommand1);

        CancelBookingCommand cancelBookingCommand1 = new CancelBookingCommand("1");
        CancelBookingCommand cancelBookingCommand2 = new CancelBookingCommand("2");
        commandHandler.handleCommand(cancelBookingCommand1);

        CreateCustomerCommand createCustomerCommand1 = new CreateCustomerCommand("John Doe 2", "1234 Main St", LocalDate.of(1990, 5, 15));
        CreateCustomerCommand createCustomerCommand2 = new CreateCustomerCommand("Jane Smith 2", "5678 Elm St", LocalDate.of(1985, 8, 20));
        commandHandler.handleCommand(createCustomerCommand1);

        CreateRoomCommand createRoomCommand1 = new CreateRoomCommand("104", 4);
        CreateRoomCommand createRoomCommand2 = new CreateRoomCommand("105", 2);
        commandHandler.handleCommand(createRoomCommand1);


    }


}
