package ChainOfResponsibility.Employee;

import ChainOfResponsibility.Handler;
import ChainOfResponsibility.Request;
import ChainOfResponsibility.RequestType;

public class Director extends Handler {

    @Override
    public void handleRequest(Request request) {
        if(request.getRequestType() == RequestType.CONFERENCE) {
            System.out.println("Director Approved the Request for "+request.getRequestType());
        } else {
            successor.handleRequest(request);
        }
    }
}
