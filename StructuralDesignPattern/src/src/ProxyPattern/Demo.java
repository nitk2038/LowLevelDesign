package ProxyPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Proxy Pattern");
        Image proxyImage = new ProxyImage("example.jpeg");
        proxyImage.display();
        proxyImage.display();
    }
}
