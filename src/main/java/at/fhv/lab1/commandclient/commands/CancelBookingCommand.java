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
    private String reservationNumber;

    public boolean validate() {
        // Überprüfen Sie, ob die Reservierungsnummer nicht null oder leer ist
        return reservationNumber != null && !reservationNumber.isEmpty();
    }
}
