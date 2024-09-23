- Separate the Algorithm from Object Structure
- Allows you to add new operations to existing classes without changing their structure    

UML Diagram
![](attachements/Pasted%20image%2020240923123206.png)

## Code

Demo class
```
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
```

Element (Interface)
```
package Visitor;  
  
public interface RoomVisitor {  
    public void visit(SingleRoom singleRoom);  
    public void visit(DoubleRoom doubleRoom);  
}
```

SingleRoom
```
package Visitor;  
  
public class SingleRoom implements  RoomElement {  
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
```

DoubleRoom
```
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
```

Room Element (Visitor Interface)
``
```
package Visitor;  
  
public interface RoomElement {  
    public void accept(RoomVisitor visitor);;  
}
```

RoomMaintenance Visitor
```
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
```

RoomPricing Visitor
```
package Visitor;  
  
public class RoomPricingVisitor implements  RoomVisitor {  
  
    @Override  
    public void visit(SingleRoom singleRoom) {  
        singleRoom.setRoomPrice(200);  
        System.out.println("Price of Single Room: Rs."+singleRoom.getRoomPrice());  
    }  
  
    @Override  
    public void visit(DoubleRoom doubleRoom) {  
        doubleRoom.setRoomPrice(500);  
        System.out.println("Price of Double Room: Rs."+doubleRoom.getRoomPrice());  
    }  
}
```

Output
```
Visitor pattern
Price of Single Room: Rs.200
Price of Double Room: Rs.500
Single Room Maintenance done
Double Room Maintenance done
```