package at.fhv.lab1.queryclient.queries;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetFreeRooms {
    private LocalDate startDate;
    private LocalDate endDate;
    private int capacity;
}