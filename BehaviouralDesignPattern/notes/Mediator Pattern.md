- Objects interact with each other without having them refer to each other explicitly.
- eg: Online Auction System

UML Diagram
![](attachements/Pasted%20image%2020240922145116.png)
- Colleagues interacts through Mediator rather than interacting directly with each other.

| Mediator            | Observer          |
| ------------------- | ----------------- |
| Defines Interaction | One to Many       |
| Object Decoupling   | Object decoupling |

## Code (Auction System)

Demo
```
package MediatorPattern;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Mediator Design Pattern");  
        AuctionMediator auctionMediator = new AuctionMediator();  
        Bidder b1 = new Bidder("nitin", auctionMediator);  
        Bidder b2 = new Bidder("sinchan", auctionMediator);  
        b1.placeBid(100);  
        b2.placeBid(300);  
        b1.placeBid(500);  
    }  
}

```


Mediator Interface
```
package MediatorPattern;  
  
public interface Mediator {  
    public void addBidder(Colleague colleague);  
    public void placeBid(Colleague colleague, int bidAmount);  
}
```

Auction Mediator
```
package MediatorPattern;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class AuctionMediator implements Mediator {  
    public List<Colleague> bidderList;  
    public AuctionMediator() {  
        this.bidderList = new ArrayList<>();  
    }  
  
    @Override  
    public void addBidder(Colleague colleague) {  
        bidderList.add(colleague);  
    }  
  
    @Override  
    public void placeBid(Colleague bidder, int bidAmount) {  
        for(Colleague colleague : bidderList) {  
            if(!(colleague.getName().equals(bidder.getName()))) {  
                colleague.receiveNotification(bidAmount);  
            }  
        }  
    }  
}
```

Colleaguer Interface
```
package MediatorPattern;  
  
public interface Colleague {  
    void placeBid(int bidAmount);  
    void receiveNotification(int bidAmount);  
    String getName();  
}

```

Bidder (Colleague Concrete)
```
package MediatorPattern;  
  
public class Bidder implements  Colleague {  
    private String name;  
    private AuctionMediator mediator;  
  
    public Bidder(String name, AuctionMediator mediator) {  
        this.mediator = mediator;  
        this.name = name;  
        mediator.addBidder(this);  
    }  
  
  
    @Override  
    public void placeBid(int bidAmount) {  
        mediator.placeBid(this, bidAmount);  
    }  
  
    @Override  
    public void receiveNotification(int bidAmount) {  
        System.out.println("Bidder " + name + " got notification that other bidder has bid Amount of " + bidAmount);  
    }  
  
    @Override  
    public String getName() {  
        return name;  
    }  
}
```

Output
```
Bidder sinchan got notification that other bidder has bid Amount of 100
Bidder nitin got notification that other bidder has bid Amount of 300
Bidder sinchan got notification that other bidder has bid Amount of 500
```