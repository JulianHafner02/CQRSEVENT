package at.fhv.lab1.commandclient.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CancelBookingCommand {
    private String bookingId;
}