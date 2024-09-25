package CreationalDesignPattern.SingletonPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern ----");
        Singleton s1 = Singleton.getInstance("foo");
        Singleton s2 = Singleton.getInstance("boo");
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        System.out.println(s1.value);
        System.out.println(s2.value);
    }
}
