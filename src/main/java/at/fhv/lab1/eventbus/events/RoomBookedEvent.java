package at.fhv.lab1.eventbus.events;

import at.fhv.lab1.commandclient.domainmodel.Customer;
import at.fhv.lab1.commandclient.domainmodel.Room;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomBookedEvent {
    private String bookingId;
    private Room room;
    private Customer customer;
    private LocalDate startTime;
    private LocalDate endTime;

}
