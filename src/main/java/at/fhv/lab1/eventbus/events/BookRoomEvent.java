package at.fhv.lab1.eventbus.events;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookRoomEvent {
    private String roomNumber;
    private String customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
