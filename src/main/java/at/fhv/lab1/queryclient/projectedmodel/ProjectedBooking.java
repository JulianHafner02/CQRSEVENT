package at.fhv.lab1.queryclient.projectedmodel;

import at.fhv.lab1.commandclient.domainmodel.Customer;
import at.fhv.lab1.commandclient.domainmodel.Room;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectedBooking {
    private String bookingId;
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
}
