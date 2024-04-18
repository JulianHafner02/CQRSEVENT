package at.fhv.lab1;

import at.fhv.lab1.queryclient.handler.QueryHandler;
import at.fhv.lab1.queryclient.queries.GetBookings;
import at.fhv.lab1.queryclient.queries.GetCustomers;
import at.fhv.lab1.queryclient.queries.GetFreeRooms;
import at.fhv.lab1.queryclient.repositories.ProjectedBookingRepository;
import at.fhv.lab1.queryclient.repositories.ProjectedCustomerRepository;
import at.fhv.lab1.queryclient.repositories.ProjectedRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
@Configuration
@ComponentScan("at.fhv.lab1.queryclient")
public class QueryClientApplication implements CommandLineRunner {

    private final QueryHandler queryHandler;
    private final ProjectedCustomerRepository projectedCustomerRepository;
    private final ProjectedRoomRepository projectedRoomRepository;
    private final ProjectedBookingRepository projectedBookingRepository;

    public QueryClientApplication(QueryHandler queryHandler, ProjectedCustomerRepository projectedCustomerRepository, ProjectedRoomRepository projectedRoomRepository, ProjectedBookingRepository projectedBookingRepository) {
        this.queryHandler = queryHandler;
        this.projectedCustomerRepository = projectedCustomerRepository;
        this.projectedRoomRepository = projectedRoomRepository;
        this.projectedBookingRepository = projectedBookingRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(QueryClientApplication.class, args);
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

            if (input.startsWith("deletequerymodel")) {
                queryHandler.deleteQueryModels();

            } else if (input.startsWith("getcustomers")) {
                String name = input.split(" ")[1];
                GetCustomers getCustomers = new GetCustomers(name);
                queryHandler.handleQuery(getCustomers);

            } else if (input.startsWith("getbookings")) {
                LocalDate dateFrom = LocalDate.of(Integer.parseInt(input.split(" ")[1]), Integer.parseInt(input.split(" ")[2]), Integer.parseInt(input.split(" ")[3]));
                LocalDate dateTo = LocalDate.of(Integer.parseInt(input.split(" ")[4]), Integer.parseInt(input.split(" ")[5]), Integer.parseInt(input.split(" ")[6]));
                GetBookings getBookings = new GetBookings(dateFrom, dateTo);
                queryHandler.handleQuery(getBookings);

            } else if (input.startsWith("getfreerooms")) {
                LocalDate dateFrom = LocalDate.of(Integer.parseInt(input.split(" ")[1]), Integer.parseInt(input.split(" ")[2]), Integer.parseInt(input.split(" ")[3]));
                LocalDate dateTo = LocalDate.of(Integer.parseInt(input.split(" ")[4]), Integer.parseInt(input.split(" ")[5]), Integer.parseInt(input.split(" ")[6]));
                int capacity = Integer.parseInt(input.split(" ")[7]);
                GetFreeRooms getFreeRooms = new GetFreeRooms(dateFrom, dateTo, capacity);
                queryHandler.handleQuery(getFreeRooms);
            }

        } while (!input.equals("exit"));

    }

}
