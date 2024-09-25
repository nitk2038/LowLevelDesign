package CreationalDesignPattern.AbstractFactoryPattern;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("This is Mac Button");
    }
}
