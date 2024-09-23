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
