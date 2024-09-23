package State;

public class FanMedState extends State {
    private Fan fan;
    public FanMedState(Fan fan) {
        this.fan = fan;
    }

    public void handleRequest() {
        System.out.println("Turning Fan Medium to High");
        fan.setState(fan.getHighState());
    }

    public String toString (){
        return "Fan is Medium Speed";
    }
}
