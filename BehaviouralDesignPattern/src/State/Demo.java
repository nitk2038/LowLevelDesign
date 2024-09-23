package State;

public class Demo {
    public static void main(String[] args) {
        System.out.println("State pattern");
        Fan fan = new Fan();
        System.out.println(fan);

        fan.pullChain();
        System.out.println(fan);

        fan.pullChain();
        System.out.println(fan);

        fan.pullChain();
        System.out.println(fan);

        fan.pullChain();
        System.out.println(fan);

    }
}
