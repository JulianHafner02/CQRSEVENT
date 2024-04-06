package at.fhv.lab1.model;

import java.util.Date;

public class Booking {

    private String bookingID;
    private Room room;
    private Customer customer;
    private Date startDate;
    private Date endDate;

    public Booking(String bookingID, Room room, Customer customer, Date startDate, Date endDate) {
        this.bookingID = bookingID;
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", room=" + room +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
