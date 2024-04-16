package at.fhv.lab1.commandclient.commands;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateRoomCommand {
    private String roomNumber;
    private int capacity;
}