package State;

public class FanLowState extends State {
    private Fan fan;
    public FanLowState(Fan fan) {
        this.fan = fan;
    }

    public void handleRequest() {
        System.out.println("Turning Fan low to Med");
        fan.setState(fan.getMedState());
    }

    public String toString (){
        return "Fan is Low speed";
    }
}
