package MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator {
    public List<Colleague> bidderList;
    public AuctionMediator() {
        this.bidderList = new ArrayList<>();
    }

    @Override
    public void addBidder(Colleague colleague) {
        bidderList.add(colleague);
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {
        for(Colleague colleague : bidderList) {
            if(!(colleague.getName().equals(bidder.getName()))) {
                colleague.receiveNotification(bidAmount);
            }
        }
    }
}
