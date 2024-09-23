- Code reuse
- Common in libraries and frameworks
- Defines the skeleton of an algorithm or operations in a superclass (often abstract) and leaves the details to be implemented by the child classes. It allows subclasses to customize specific parts of the algorithm without altering its overall structure.
- eg: Order, BrewingCoffee

	UML Diagram
	![](attachements/Pasted%20image%2020240923121657.png)

##  Code

Demo class
```
package Template;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Template pattern");  
        System.out.println("--- STORE ORDER ----- ");  
        OrderTemplate storeOrder = new StoreOrder();  
        storeOrder.processOrder();  
        System.out.println("------------------------");  
  
        System.out.println("--- ONLINE ORDER ----- ");  
        OrderTemplate onlineOrder = new OnlineOrder();  
        onlineOrder.processOrder();  
        System.out.println("------------------------");  
    }  
}
```

OrderTemplate (AbstractBase)
- here we have defined the method as public final void which cannot change
```
package Template;  
  
public abstract class OrderTemplate {  
    public abstract void doCheckout();  
    public abstract void doPayment();  
    public abstract void deliver();  
    public abstract  void doReceipt();  
  
    public final void processOrder() {  
        doCheckout();  
        doPayment();  
        doReceipt();  
        deliver();  
    }  
}

```

StoreOrder (Concrete Class)
```
package Template;  
  
public class StoreOrder extends OrderTemplate {  
  
    @Override  
    public void doCheckout() {  
        System.out.println("ADD ITEMS TO BAG");  
    }  
  
    @Override  
    public void doPayment() {  
        System.out.println("PAY IN CASH");  
    }  
  
    @Override  
    public void deliver() {  
        System.out.println("PACK ITEMS FROM BAG");  
    }  
  
    @Override  
    public void doReceipt() {  
        System.out.println("RECEIPT PRINTED....");  
    }  
}
```

OnlineOrder
```
package Template;  
  
public class OnlineOrder extends OrderTemplate {  
  
    @Override  
    public void doCheckout() {  
        System.out.println("ADD ITEMS TO CART");  
    }  
  
    @Override  
    public void doPayment() {  
        System.out.println("SWIPE WITH CARD OR DO PAYMENT WITH UPI");  
    }  
  
    @Override  
    public void deliver() {  
        System.out.println("DELIVERING ITEMS IN 1 WEEK");  
    }  
  
    @Override  
    public void doReceipt() {  
        System.out.println("INVOICE SENT TO MAIL");  
    }  
}
```

Output
```
Template pattern
--- STORE ORDER ----- 
ADD ITEMS TO BAG
PAY IN CASH
RECEIPT PRINTED....
PACK ITEMS FROM BAG
------------------------
--- ONLINE ORDER ----- 
ADD ITEMS TO CART
SWIPE WITH CARD OR DO PAYMENT WITH UPI
INVOICE SENT TO MAIL
DELIVERING ITEMS IN 1 WEEK
------------------------

```