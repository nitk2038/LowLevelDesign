- Decouples a request from handling objects in a chain of handlers until it's finally recognized.
- UML Diagram ![](attachements/Pasted%20image%2020240921230058.png)
   - Eg: Logging / Approvals of a request at Direcor / VP /CEO level
### Pitfalls
- Handling / Handler Guarantee
- Chain length / performance issues

Similar to Command Design Pattern

| Chain of Responsibility | Command                           |
| ----------------------- | --------------------------------- |
| Handler is unique       | Command is also unique            |
| Not Trackable           | Reversible or trackable in nature |


# Code

Demo Class
```
package ChainOfResponsibility;  
  
import ChainOfResponsibility.Employee.CEO;  
import ChainOfResponsibility.Employee.Director;  
import ChainOfResponsibility.Employee.VP;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Chain of Responsibility Pattern");  
        Director director = new Director();  
        VP vp = new VP();  
        CEO ceo = new CEO();  
  
        director.setSuccessor(vp);  
        vp.setSuccessor(ceo);  
  
        Request request = new Request(RequestType.CONFERENCE, 5000);  
        director.handleRequest(request);  
  
        Request request2 = new Request(RequestType.ONSITE, 1400);  
        director.handleRequest(request2);  
  
        Request request3 = new Request(RequestType.ONSITE, 9000);  
        director.handleRequest(request3);  
  
    }  
}

```

Request Class
```
package ChainOfResponsibility;  
  
public class Request {  
    private final double amount;  
    private final RequestType requestType;  
  
    public Request(RequestType requestType, double amount) {  
        this.requestType = requestType;  
        this.amount = amount;  
    }  
  
    public double getAmount() {  
        return amount;  
    }  
  
    public RequestType getRequestType() {  
        return requestType;  
    }  
}
```

RequestType
```
public enum RequestType {  
    CONFERENCE, ONSITE  
}
```

Handler Class
```
package ChainOfResponsibility;  
  
public abstract class Handler {  
    protected Handler successor;  
    public void setSuccessor(Handler successor) {  
        this.successor = successor;  
    }  
    public abstract void handleRequest(Request request);  
}
```

Director
```
public class Director extends Handler {  
  
    @Override  
    public void handleRequest(Request request) {  
        if(request.getRequestType() == RequestType.CONFERENCE) {  
            System.out.println("Director Approved the Request for "+request.getRequestType());  
        } else {  
            successor.handleRequest(request);  
        }  
    }  
}
```

VP
```
public class VP extends Handler {  
    @Override  
    public void handleRequest(Request request) {  
        if(request.getRequestType() == RequestType.ONSITE) {  
            if(request.getAmount() < 1500) {  
                System.out.println("VP has approved the onsite request for budget $"+request.getAmount());  
            } else {  
                successor.handleRequest(request);  
            }  
        }  
    }  
}
```

CEO
```
public class CEO extends Handler {  
    @Override  
    public void handleRequest(Request request) {  
        System.out.println("CEO approves the request "+request.getRequestType() +" for amount $"+request.getAmount());  
    }  
}
```

Output
```
Chain of Responsibility Pattern
Director Approved the Request for CONFERENCE
VP has approved the onsite request for budget $1400.0
CEO approves the request ONSITE for amount $9000.0
```