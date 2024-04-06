package at.fhv.lab1.commandclient;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CreateCustomerCommand {
    private String name;
    private String address;
    private LocalDate dateOfBirth;
}
