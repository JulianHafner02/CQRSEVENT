package at.fhv.lab1.commandclient.commands;

import java.time.LocalDate;
import java.time.LocalDateTime;

import at.fhv.lab1.commandclient.domainmodel.Customer;
import at.fhv.lab1.commandclient.domainmodel.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookRoomCommand {
    private String bookingId;
    private Room room;
    private Customer customer;
    private LocalDate startTime;
    private LocalDate endTime;


}
