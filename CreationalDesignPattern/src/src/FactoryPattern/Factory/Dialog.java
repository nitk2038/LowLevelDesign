package CreationalDesignPattern.FactoryPattern.Factory;

import CreationalDesignPattern.FactoryPattern.Buttons.Button;

public abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }
    public abstract Button createButton();
}
