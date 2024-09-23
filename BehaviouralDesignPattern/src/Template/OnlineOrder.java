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
