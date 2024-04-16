package at.fhv.lab1.eventbus.events;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomCreatedEvent {
    private String roomNumber;
    private int capacity;
}