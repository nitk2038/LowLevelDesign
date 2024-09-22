package CommandPattern;

public class Light {
    //receiver
    public boolean isOn = false;
    public boolean getIsOn() {
        return isOn;
    }

    public void toggle() {
        if(isOn) {
            off();
            isOn = false;
        } else {
            on();
            isOn = true;
        }
    }
    public void on() {
        System.out.println("Light Switched On");
    }

    public void off() {
        System.out.println("Light Switched off");
    }
}
