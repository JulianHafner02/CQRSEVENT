package at.fhv.lab1.queryclient.projectedmodel;

import at.fhv.lab1.commandclient.domainmodel.Customer;
import at.fhv.lab1.commandclient.domainmodel.Room;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectedBooking {
    private String bookingId;
    private ProjectedRoom room;
    private ProjectedCustomer customer;
    private LocalDate startDate;
    private LocalDate endDate;
}
