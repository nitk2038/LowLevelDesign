package MediatorPattern;

public class Bidder implements  Colleague {
    private String name;
    private AuctionMediator mediator;

    public Bidder(String name, AuctionMediator mediator) {
        this.mediator = mediator;
        this.name = name;
        mediator.addBidder(this);
    }


    @Override
    public void placeBid(int bidAmount) {
        mediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveNotification(int bidAmount) {
        System.out.println("Bidder " + name + " got notification that other bidder has bid Amount of " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
