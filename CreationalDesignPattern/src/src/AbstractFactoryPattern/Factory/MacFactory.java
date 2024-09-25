package CreationalDesignPattern.AbstractFactoryPattern.Factory;

import CreationalDesignPattern.AbstractFactoryPattern.Button;
import CreationalDesignPattern.AbstractFactoryPattern.Factory.GUIFactory;
import CreationalDesignPattern.AbstractFactoryPattern.MacButton;

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
}
