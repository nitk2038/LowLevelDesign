package Visitor;

public class RoomMaintenanceVisitor implements  RoomVisitor {

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Single Room Maintenance done");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Double Room Maintenance done");
    }
}
