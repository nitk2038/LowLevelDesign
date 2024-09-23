- Subject has one to many observers
- Subject is a class that observers will register themselves with.
- eg: Stocks Notify in Ecommerce, WeatherStation Alert

UML Diagram
![](attachements/Pasted%20image%2020240922170931.png)

## Code

Demo class
```
package Observer;  
  
public class Demo {  
    public static void main(String[] args) {  
        System.out.println("Observer pattern");  
  
        StocksObservable iphoneStocksObservable = new IphoneObservable();  
        NotificationAlertObserver observer1 = new EmailNotificationObserver("nitin123@gmail.com", iphoneStocksObservable);  
        NotificationAlertObserver observer2 = new EmailNotificationObserver("sinchan@gmail.com", iphoneStocksObservable);  
        NotificationAlertObserver observer3 = new MobileNotificationObserver("+9111334455", iphoneStocksObservable);  
  
        iphoneStocksObservable.add(observer1);  
        iphoneStocksObservable.add(observer2);  
        iphoneStocksObservable.add(observer3);  
  
        iphoneStocksObservable.setStockCount(5);  
    }  
}
```

Observer Interface
```
public interface NotificationAlertObserver {  
    public void update();  
}
```

Email Observer Impl
```
package Observer;  
  
public class EmailNotificationObserver implements NotificationAlertObserver {  
    public String emailId;  
    public StocksObservable stocksObservable;  
  
    public EmailNotificationObserver(String emailId, StocksObservable stocksObservable) {  
        this.emailId = emailId;  
        this.stocksObservable = stocksObservable;  
    }  
  
    @Override  
    public void update() {  
        sendMail(emailId, "Product is in Stock!! Hurry Up!!");  
    }  
  
    public void sendMail(String emailId, String message) {  
        System.out.println("Email sent to " + emailId + " \n content: "+ message);  
    }  
}
```

Mobile Observer Impl
```
public class MobileNotificationObserver implements NotificationAlertObserver {  
    public String phoneNumber;  
    public StocksObservable stocksObservable;  
  
    public MobileNotificationObserver(String phoneNumber, StocksObservable stocksObservable) {  
        this.phoneNumber = phoneNumber;  
        this.stocksObservable = stocksObservable;  
    }  
  
    @Override  
    public void update() {  
        sendMail(phoneNumber, "Product is in Stock!! Hurry Up!!");  
    }  
  
    public void sendMail(String phoneNumber, String message) {  
        System.out.println("SMS sent to " + phoneNumber + " \n sms: "+ message);  
    }  
}
```

Stocks Observable Interface
```
public interface StocksObservable {  
    public void add(NotificationAlertObserver notificationAlertObserver);  
    public void remove(NotificationAlertObserver notificationAlertObserver);  
    public void notifySubscribers();  
    public void setStockCount(int newStockAdded);  
    public int getStockCount();  
}
```

Iphone Observable Impl
```
package Observer;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class IphoneObservable implements StocksObservable {  
    public List<NotificationAlertObserver>observersList;  
    public int stockCount;  
  
    public IphoneObservable() {  
        this.observersList = new ArrayList<>();  
        this.stockCount = 0;  
    }  
  
    @Override  
    public void add(NotificationAlertObserver notificationAlertObserver) {  
        observersList.add(notificationAlertObserver);  
    }  
  
    @Override  
    public void remove(NotificationAlertObserver notificationAlertObserver) {  
        observersList.remove(notificationAlertObserver);  
    }  
  
    @Override  
    public void notifySubscribers() {  
        for(NotificationAlertObserver observer: observersList) {  
            observer.update();  
        }  
    }  
  
    @Override  
    public void setStockCount(int newStockAdded) {  
        //we are getting newStocks , when we were currently out of stock  
        if(stockCount == 0) {  
            notifySubscribers();  
        }  
        this.stockCount+=newStockAdded;  
    }  
  
    @Override  
    public int getStockCount() {  
        return stockCount;  
    }  
}
```

Output
```
Observer pattern
Email sent to nitin123@gmail.com 
 content: Product is in Stock!! Hurry Up!!
Email sent to sinchan@gmail.com 
 content: Product is in Stock!! Hurry Up!!
SMS sent to +9111334455 
 sms: Product is in Stock!! Hurry Up!!
```