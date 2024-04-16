package at.fhv.lab1;

import at.fhv.lab1.eventbus.EventPublisher;
import at.fhv.lab1.eventbus.EventRepository;
import at.fhv.lab1.queryclient.queries.GetBookings;
import at.fhv.lab1.queryclient.queries.GetCustomers;
import at.fhv.lab1.queryclient.queries.GetFreeRooms;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.eventbus")
public class EventBus implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final EventPublisher eventPublisher;

    public EventBus(EventRepository eventRepository, EventPublisher eventPublisher) {
        this.eventRepository = eventRepository;
        this.eventPublisher = eventPublisher;
    }

    public static void main(String[] args) {
        SpringApplication.run(EventBus.class, args);
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

            if(input.startsWith("restoreall")) {
                eventRepository.getAllRoomCreatedEvents().forEach(eventPublisher::publishEvent);
                eventRepository.getAllCustomerCreatedEvents().forEach(eventPublisher::publishEvent);
                eventRepository.getAllRoomBookedEvents().forEach(eventPublisher::publishEvent);
                eventRepository.getAllBookingCancelledEvents().forEach(eventPublisher::publishEvent);

                System.out.println("All Events Restored");

            } else if(input.startsWith("getallevents")) {
                eventRepository.printAllEvents();
            }


        } while (!input.equals("exit"));

    }
}
