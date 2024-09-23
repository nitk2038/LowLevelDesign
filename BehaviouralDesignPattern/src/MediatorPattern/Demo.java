package MediatorPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Mediator Design Pattern");
        AuctionMediator auctionMediator = new AuctionMediator();
        Bidder b1 = new Bidder("nitin", auctionMediator);
        Bidder b2 = new Bidder("sinchan", auctionMediator);
        b1.placeBid(100);
        b2.placeBid(300);
        b1.placeBid(500);
    }
}
