package at.fhv.lab1.commandclient.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
    private String roomNumber;
    private int capacity;
}
