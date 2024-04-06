package at.fhv.lab1.commandclient.commands;

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

    public boolean validate() {

        if (roomNumber == null || customerId == null || startTime == null || endTime == null) {
            return false;
        }

        if (startTime.isAfter(endTime)) {
            return false;
        }
        return true;
    }
}
