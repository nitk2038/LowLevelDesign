package CreationalDesignPattern.AbstractFactoryPattern;

import CreationalDesignPattern.AbstractFactoryPattern.Factory.GUIFactory;

public class Application {
    private Button button;
    public Application (GUIFactory factory) {
        button = factory.createButton();
    }

    public void paint() {
        button.paint();
    }
}
