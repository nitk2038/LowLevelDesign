package Observer;

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
