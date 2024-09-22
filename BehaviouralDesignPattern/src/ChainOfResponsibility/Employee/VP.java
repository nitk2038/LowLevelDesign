package ChainOfResponsibility.Employee;

import ChainOfResponsibility.Handler;
import ChainOfResponsibility.Request;
import ChainOfResponsibility.RequestType;

public class VP extends Handler {
    @Override
    public void handleRequest(Request request) {
        if(request.getRequestType() == RequestType.ONSITE) {
            if(request.getAmount() < 1500) {
                System.out.println("VP has approved the onsite request for budget $"+request.getAmount());
            } else {
                successor.handleRequest(request);
            }
        }
    }
}
