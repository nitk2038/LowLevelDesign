package ChainOfResponsibility;

public class Request {
    private final double amount;
    private final RequestType requestType;

    public Request(RequestType requestType, double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
