package ChainOfResponsibility;

import ChainOfResponsibility.Employee.CEO;
import ChainOfResponsibility.Employee.Director;
import ChainOfResponsibility.Employee.VP;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Chain of Responsibility Pattern");
        Director director = new Director();
        VP vp = new VP();
        CEO ceo = new CEO();

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        Request request = new Request(RequestType.CONFERENCE, 5000);
        director.handleRequest(request);

        Request request2 = new Request(RequestType.ONSITE, 1400);
        director.handleRequest(request2);

        Request request3 = new Request(RequestType.ONSITE, 9000);
        director.handleRequest(request3);

    }
}
