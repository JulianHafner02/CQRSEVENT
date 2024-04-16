package at.fhv.lab1.commandclient.domainmodel;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Booking {
    private String bookingId;
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
}