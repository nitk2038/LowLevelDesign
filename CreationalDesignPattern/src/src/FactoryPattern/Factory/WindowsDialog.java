package CreationalDesignPattern.FactoryPattern.Factory;

import CreationalDesignPattern.FactoryPattern.Buttons.Button;
import CreationalDesignPattern.FactoryPattern.Buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    public Button createButton() {
        return new WindowsButton();
    }
}
