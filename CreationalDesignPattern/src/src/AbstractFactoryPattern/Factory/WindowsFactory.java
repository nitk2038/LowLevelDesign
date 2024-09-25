package CreationalDesignPattern.AbstractFactoryPattern.Factory;

import CreationalDesignPattern.AbstractFactoryPattern.Button;
import CreationalDesignPattern.AbstractFactoryPattern.Factory.GUIFactory;
import CreationalDesignPattern.AbstractFactoryPattern.WindowsButton;

public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
}
