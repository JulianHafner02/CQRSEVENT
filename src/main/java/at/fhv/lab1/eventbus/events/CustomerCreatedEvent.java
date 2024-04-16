package at.fhv.lab1.eventbus.events;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerCreatedEvent {
    private String name;
    private String address;
    private LocalDate dateOfBirth;
}