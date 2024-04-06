package at.fhv.lab1.commandclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CancelBookingCommand {
    private String reservationNumber;
}
