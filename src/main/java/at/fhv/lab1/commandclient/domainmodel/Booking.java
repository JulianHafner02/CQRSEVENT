package at.fhv.lab1.commandclient.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Booking {
    private String bookingID;
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
}
