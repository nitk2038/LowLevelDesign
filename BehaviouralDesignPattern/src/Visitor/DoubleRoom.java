package Visitor;

public class DoubleRoom implements  RoomElement {
    private int roomPrice = 0;
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
}
