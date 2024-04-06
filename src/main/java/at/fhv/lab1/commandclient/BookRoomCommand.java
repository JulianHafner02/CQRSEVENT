package at.fhv.lab1.commandclient;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRoomCommand {
    private String roomNumber;
    private String customerID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Konstruktor, Getter und Setter und ToString


    public BookRoomCommand(String roomNumber, String customerId, LocalDateTime startTime, LocalDateTime endTime) {
        this.roomNumber = roomNumber;
        this.customerID = customerId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCustomerId() {
        return customerID;
    }

    public void setCustomerId(String customerId) {
        this.customerID = customerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BookRoomCommand{" +
                "roomNumber='" + roomNumber + '\'' +
                ", customerId='" + customerID + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
