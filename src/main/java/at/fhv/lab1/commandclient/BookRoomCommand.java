package at.fhv.lab1.commandclient;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookRoomCommand {
    private String roomNumber;
    private String customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
