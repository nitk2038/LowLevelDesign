package MediatorPattern;

public interface Mediator {
    public void addBidder(Colleague colleague);
    public void placeBid(Colleague colleague, int bidAmount);
}
