package State;

public class FanHighState extends State {
    private Fan fan;
    public FanHighState(Fan fan) {
        this.fan = fan;
    }

    public void handleRequest() {
        System.out.println("Turning Fan High to Off");
        fan.setState(fan.getOffState());
    }

    public String toString (){
        return "Fan is High Speed";
    }
}
