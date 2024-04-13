package at.fhv.lab1.queryclient.projectedmodel;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectedCustomer {
    private String name;
    private String address;
    private LocalDate dateOfBirth;
}
