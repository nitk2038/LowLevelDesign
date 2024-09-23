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
