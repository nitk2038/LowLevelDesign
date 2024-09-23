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
