package at.fhv.lab1.model;

public class Room {

    private String roomID;
    private int size;

    public Room(String roomID, int size) {
        this.roomID = roomID;
        this.size = size;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID='" + roomID + '\'' +
                ", size=" + size +
                '}';
    }
}
