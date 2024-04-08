package at.fhv.lab1.queryclient.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetBookings {
    private LocalDate startDate;
    private LocalDate endDate;
}