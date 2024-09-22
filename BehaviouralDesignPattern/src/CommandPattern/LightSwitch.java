package CommandPattern;

public class LightSwitch {
    //invoker
    public void storeAndExecute(Command command) {
        command.execute();
    }
}
