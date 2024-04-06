package at.fhv.lab1.commandclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelBookingCommand {
    private String reservationNumber;

    // Konstruktor, Getter und Setter und ToString


    public CancelBookingCommand(String reservationNumber) {
        this.reservationNumber = reservationNumber;

    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    @Override
    public String toString() {
        return "CancelBookingCommand{" +
                "reservationNumber='" + reservationNumber + '\'' +
                '}';
    }
}