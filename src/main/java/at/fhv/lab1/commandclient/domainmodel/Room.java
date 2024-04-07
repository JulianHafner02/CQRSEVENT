package at.fhv.lab1.commandclient.domainmodel;

import lombok.*;

@Data
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Room {
    private String roomNumber;
    private int capacity;
}
