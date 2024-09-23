package State;

public class FanOffState extends State {
    private Fan fan;
    public FanOffState(Fan fan) {
        this.fan = fan;
    }

    public void handleRequest() {
        System.out.println("Turning Fan on from off");
        fan.setState(fan.getLowState());
    }

    public String toString (){
        return "Fan is off";
    }
}
