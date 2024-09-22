package CommandPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Command Design Pattern");
        Light light = new Light();
        LightSwitch lightSwitch = new LightSwitch();
        Command toggleCommand = new ToggleCommand(light);

        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
    }
}
