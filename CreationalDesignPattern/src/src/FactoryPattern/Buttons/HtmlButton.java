package CreationalDesignPattern.FactoryPattern.Buttons;

public class HtmlButton implements Button {
    public void render() {
        System.out.println("Rendering HTML <html><body><h1>Hello world</h1></body></html>");
    }
}
