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

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CommandHandler commandHandler;


    //TODO Dokumentation macha (klassendiagramm und die ansteuerung der commands)
    //TODO akle code cleanup

    public CommandClientApplication(RoomRepository roomRepository, BookingRepository bookingRepository, CustomerRepository customerRepository, CommandHandler commandHandler) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.commandHandler = commandHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandClientApplication.class, args);
    }

    public void run(String ... args) throws Exception {

        System.out.println("Running");

        // Read input from the command line
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter a command:");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);


            if (input.startsWith("initialise")) {
                initialiseData();
            }
            else if (input.startsWith("createroom")) {

                String roomNumber = input.split(" ")[1];
                int capacity = Integer.parseInt(input.split(" ")[2]);
                CreateRoomCommand createRoomCommand = new CreateRoomCommand(roomNumber, capacity);
                commandHandler.handleCommand(createRoomCommand);

            }else if(input.startsWith("createcustomer")) {

                String name = input.split(" ")[1];
                String address = input.split(" ")[2];
                LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(input.split(" ")[3]), Integer.parseInt(input.split(" ")[4]), Integer.parseInt(input.split(" ")[5]));
                CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand(name, address, dateOfBirth);
                commandHandler.handleCommand(createCustomerCommand);
            }else if(input.startsWith("bookroom")) {

                String bookingId = input.split(" ")[1];
                String roomNumber = input.split(" ")[2];
                String customerName = input.split(" ")[3];
                LocalDate dateFrom = LocalDate.of(Integer.parseInt(input.split(" ")[4]), Integer.parseInt(input.split(" ")[5]), Integer.parseInt(input.split(" ")[6]));
                LocalDate dateTo = LocalDate.of(Integer.parseInt(input.split(" ")[7]), Integer.parseInt(input.split(" ")[8]), Integer.parseInt(input.split(" ")[9]));
                BookRoomCommand bookRoomCommand = new BookRoomCommand(bookingId, roomRepository.findByRoomNumber(roomNumber), customerRepository.findByCustomerName(customerName), dateFrom, dateTo);
                commandHandler.handleCommand(bookRoomCommand);
            }else if (input.startsWith("cancelbooking")) {

                String bookingId = input.split(" ")[1];
                CancelBookingCommand cancelBookingCommand = new CancelBookingCommand(bookingId);
                commandHandler.handleCommand(cancelBookingCommand);
            }

        } while (!input.equals("exit"));

    }

    public void initialiseData() {

        // Create some sample data for rooms, bookings, and customers

        CreateRoomCommand createRoomCommand1 = new CreateRoomCommand("201", 2);
        CreateRoomCommand createRoomCommand2 = new CreateRoomCommand("202", 3);
        CreateRoomCommand createRoomCommand3 = new CreateRoomCommand("203", 4);
        commandHandler.handleCommand(createRoomCommand1);
        commandHandler.handleCommand(createRoomCommand2);
        commandHandler.handleCommand(createRoomCommand3);

        CreateCustomerCommand createCustomerCommand1 = new CreateCustomerCommand("John", "1234 Main St", LocalDate.of(1990, 5, 15));
        CreateCustomerCommand createCustomerCommand2 = new CreateCustomerCommand("Jane", "456 Main St", LocalDate.of(1995, 8, 20));
        commandHandler.handleCommand(createCustomerCommand1);
        commandHandler.handleCommand(createCustomerCommand2);

        BookRoomCommand bookRoomCommand = new BookRoomCommand("1", roomRepository.findByRoomNumber("201") , customerRepository.findByCustomerName("John"), LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 18));
        BookRoomCommand bookRoomCommand2 = new BookRoomCommand("2", roomRepository.findByRoomNumber("202") , customerRepository.findByCustomerName("Jane"), LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 18));
        commandHandler.handleCommand(bookRoomCommand);
        commandHandler.handleCommand(bookRoomCommand2);


        CancelBookingCommand cancelBookingCommand1 = new CancelBookingCommand("1");
        commandHandler.handleCommand(cancelBookingCommand1);

    }
}
