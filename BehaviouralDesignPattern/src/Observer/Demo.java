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
