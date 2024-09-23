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
