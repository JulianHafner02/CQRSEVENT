package at.fhv.lab1.eventbus.events;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingCancelledEvent {
    private String bookingId;
}