package ChainOfResponsibility.Employee;

import ChainOfResponsibility.Handler;
import ChainOfResponsibility.Request;

public class CEO extends Handler {
    @Override
    public void handleRequest(Request request) {
        System.out.println("CEO approves the request "+request.getRequestType() +" for amount $"+request.getAmount());
    }
}
