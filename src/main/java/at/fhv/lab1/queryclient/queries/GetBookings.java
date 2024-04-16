package at.fhv.lab1.queryclient.queries;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetBookings {
    private LocalDate startDate;
    private LocalDate endDate;
}