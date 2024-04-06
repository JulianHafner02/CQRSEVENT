package at.fhv.lab1.eventbus.events;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {
    private String customer;
    private long timestamp;
    private String content;
}
