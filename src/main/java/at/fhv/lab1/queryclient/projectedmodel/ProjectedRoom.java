package at.fhv.lab1.queryclient.projectedmodel;


import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectedRoom {
    private String roomNumber;
    private int capacity;
    private ArrayList<LocalDate> bookedFor = new ArrayList<>();
}