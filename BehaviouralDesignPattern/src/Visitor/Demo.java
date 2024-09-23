package Visitor;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Visitor pattern");
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomVisitor pricingVisitorObj = new RoomPricingVisitor();
        RoomVisitor roomMaintenanceObj = new RoomMaintenanceVisitor();

        singleRoom.accept(pricingVisitorObj);
        doubleRoom.accept(pricingVisitorObj);

        singleRoom.accept(roomMaintenanceObj);
        doubleRoom.accept(roomMaintenanceObj);
    }
}
