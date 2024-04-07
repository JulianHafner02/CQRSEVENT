package at.fhv.lab1.commandclient.domainmodel;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    private String name;
    private String address;
    private LocalDate dateOfBirth;
}
