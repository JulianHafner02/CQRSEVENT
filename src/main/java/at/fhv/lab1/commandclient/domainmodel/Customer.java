package at.fhv.lab1.commandclient.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Customer {
    private String customerID;
    private String name;
    private String address;
    private LocalDate dateOfBirth;
}
